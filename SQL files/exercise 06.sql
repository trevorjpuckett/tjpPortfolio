-- # Trevor J Puckett
-- # 10/23/2018
-- # Exercise 06 -- CPT 242



#1
SELECT SUM(invoice_total), vendor_id FROM invoices GROUP BY vendor_id;
#2
SELECT SUM(payment_total), vendor_name FROM invoices i, vendors v 
WHERE v.vendor_id=i.vendor_id 
GROUP BY vendor_name ORDER BY payment_total desc;
#3
SELECT vendor_name, COUNT(invoice_number) as number_of_invoices, SUM(invoice_total)  
FROM vendors v, invoices i WHERE v.vendor_id=i.vendor_id
GROUP BY vendor_name ORDER BY COUNT(invoice_number) desc;
#4
SELECT account_description, COUNT(ili.account_number), SUM(line_item_amount)
FROM general_ledger_accounts gla, invoice_line_items ili
WHERE gla.account_number=ili.account_number 
GROUP BY account_description HAVING COUNT(ili.account_number)>1
ORDER BY SUM(line_item_amount) desc;
#5
SELECT account_description, COUNT(ili.account_number), SUM(line_item_amount)
FROM general_ledger_accounts gla, invoice_line_items ili, invoices i
WHERE gla.account_number=ili.account_number AND ili.invoice_id=i.invoice_id 
AND invoice_date BETWEEN '2014-04-01' AND '2014-06-30'
GROUP BY account_description HAVING COUNT(ili.account_number)>1 
ORDER BY SUM(line_item_amount) desc;
#6
SELECT gla.account_number, SUM(line_item_amount) 
FROM general_ledger_accounts gla, invoice_line_items ili
WHERE gla.account_number=ili.account_number
GROUP BY account_number WITH ROLLUP;
#7
SELECT vendor_name, COUNT(DISTINCT account_number) 
FROM vendors v, invoice_line_items ili, invoices i 
WHERE v.vendor_id=i.vendor_id AND i.invoice_id=ili.invoice_id
GROUP BY vendor_name HAVING COUNT(DISTINCT account_number)>1;