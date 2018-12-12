-- # Trevor J Puckett
-- # 10/9/2018
-- # Exercise 04 -- CPT 242


#1
SELECT * FROM vendors INNER JOIN invoices 
	ON vendors.vendor_id = invoices.vendor_id;
#2
SELECT invoice_number, vendor_name, invoice_due_date, invoice_total-payment_total-credit_total as balance_due
FROM vendors v  join invoices i
	ON v.vendor_id=i.vendor_id
WHERE invoice_total-payment_total-credit_total>0
ORDER BY vendor_name;
#3
SELECT vendor_name, default_account_number default_account, account_description description
FROM vendors INNER JOIN general_ledger_accounts
	ON vendors.default_account_number=general_ledger_accounts.account_number
ORDER BY account_description, vendor_name;
#4
SELECT vendor_name, invoice_date, invoice_number, invoice_sequence li_sequence, line_item_amount li_amount
FROM vendors INNER JOIN invoices 
	ON vendors.vendor_id=invoices.vendor_id
INNER JOIN invoice_line_items il
	ON invoices.invoice_id=il.invoice_id
ORDER BY vendor_name, invoice_date, invoice_number, invoice_sequence;
#5
SELECT v1.vendor_id, v1.vendor_name, CONCAT(v1.vendor_contact_first_name, " ", v1.vendor_contact_last_name) AS contact_name 
FROM vendors v1, vendors v2
WHERE v1.vendor_id!=v2.vendor_id AND v1.vendor_contact_last_name=v2.vendor_contact_last_name
ORDER BY v1.vendor_contact_last_name;
#6
SELECT gl.account_number, account_description, il.invoice_id
FROM general_ledger_accounts gl LEFT OUTER JOIN  invoice_line_items il
	ON gl.account_number=il.account_number
WHERE il.invoice_id IS NULL
ORDER BY gl.account_number;