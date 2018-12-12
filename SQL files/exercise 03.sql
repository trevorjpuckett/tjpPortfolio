-- # Trevor J Puckett
-- # 10/10/2018
-- # Exercise 03 -- CPT 242

#6
SELECT vendor_name, vendor_contact_last_name, vendor_contact_first_name 
FROM vendors ORDER BY vendor_contact_last_name, vendor_contact_first_name;
#7
SELECT CONCAT(vendor_contact_last_name, ', ',vendor_contact_first_name) full_name
FROM vendors WHERE vendor_contact_last_name LIKE 'A%' OR vendor_contact_last_name LIKE 'B%'
OR vendor_contact_last_name LIKE 'C%' OR vendor_contact_last_name LIKE 'e%' 
ORDER BY vendor_contact_last_name, vendor_contact_first_name;
#8
SELECT invoice_due_date, invoice_total, (invoice_total*.1) '10%', (invoice_total*1.10) 'Plus 10%' 
FROM invoices WHERE invoice_total>=500 and invoice_total<=1000
ORDER BY invoice_due_date desc;
#9
SELECT invoice_number, invoice_total, (payment_total+credit_total) payment_credit_total, (invoice_total-payment_total-credit_total) as balance_due 
FROM invoices WHERE invoice_total-payment_total-credit_total>50
ORDER BY invoice_total-payment_total-credit_total desc
LIMIT 5;
#10
SELECT invoice_number, invoice_date, (invoice_total-payment_total-credit_total) as balance_due, payment_date
FROM invoices WHERE payment_date IS NULL;

#11
SELECT CURRENT_DATE,
    DATE_FORMAT(CURRENT_DATE, '%e-%b-%Y') AS 'current_date';
#12
SELECT  '$50,0000' as starting_principal, '6.5%' as interest, (50000 + 50000*.065) as principal_plus_interest;