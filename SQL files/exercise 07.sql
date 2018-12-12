-- # Trevor J Puckett
-- # 11/20/2018
-- # Exercise 07 -- CPT 242


/* #1 */
SELECT DISTINCT vendor_name FROM vendors, invoices
WHERE vendors.vendor_id = invoices.vendor_id
ORDER BY vendor_name;

/* #2
Which invoices have a payment total 
that is greater than the average payment total for 
all invoics with a payment total greater than 0 */

SELECT payment_total FROM invoices
WHERE payment_total > (SELECT AVG(payment_total) 
					   FROM invoices 
                       WHERE payment_total > 0);
                       
/* #3
Return one row for each account number that has never been assigned to any line item in the invoice line items
use subquery introduced with the NOT EXISTS operator returns 54 rows  */

SELECT account_number, account_description 
FROM general_ledger_accounts gla
WHERE NOT EXISTS (SELECT * FROM invoice_line_items ili 
				  WHERE gla.account_number = ili.account_number)
ORDER BY account_number;

/* #4    
return a row for each line item of each invoice that has more than one line item in the invoice line items table
use a subquery that tests for invoice_sequence > 1 returns 6 rows */

SELECT vendor_name, ili.invoice_id, invoice_sequence, line_item_amount 
FROM invoice_line_items ili JOIN invoices i
	ON ili.invoice_id = i.invoice_id JOIN vendors v
    ON i.vendor_id = v.vendor_id
WHERE ili.invoice_id IN (SELECT invoice_id 
						 FROM invoice_line_items 
                         WHERE invoice_sequence > 1);
                         
/* #7 
use a correlated subquery to return one row per vendor,
representing the vendors oldest invoice (the one with the earliest date)
each row should include vendor name, invoice number, invoice date, and invoice total
sort results by vendor name */

SELECT v.vendor_name, i.invoice_number, i.invoice_date,
i.invoice_total
FROM vendors v JOIN invoices i
	ON v.vendor_id = i.vendor_id JOIN(SELECT MIN(invoice_date) AS min_invoice_date, i2.vendor_id 
									  FROM invoices i2
                                      GROUP BY i2.vendor_id) mi
	ON mi.vendor_id = v.vendor_id 
    AND mi.min_invoice_date = i.invoice_date
ORDER BY invoice_date; 
