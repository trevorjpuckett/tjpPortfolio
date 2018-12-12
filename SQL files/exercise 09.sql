/* Trevor J Puckett
11/16/2018
Exercise 09 -- CPT 242 */

select * from vendors;
select * from invoices;

SELECT DISTINCT vendor_name FROM vendors v
WHERE v.vendor_id IN	
		(SELECT i.vendor_id
		 FROM invoices i )
ORDER BY vendor_name;

SELECT invoice_number, invoice_total FROM invoices;


SELECT invoice_total,
	   ROUND(invoice_total,1) AS invoice_total_one ,
	   ROUND(invoice_total,0) AS invoice_total_zero
FROM invoices;

SELECT vendor_name,
		UPPER(vendor_name),
        vendor_phone,
       SUBSTRING(vendor_phone,11) as vendor_last_4,
       CONCAT(SUBSTRING(vendor_phone,2,3), ".", SUBSTRING(vendor_phone,7,3), ".",SUBSTRING(vendor_phone,11)) as vendor_phone_2,
      SUBSTRING(vendor_name, LOCATE(' ' , vendor_name),LOCATE(' ', LTRIM(SUBSTRING(vendor_name, LOCATE(' ' , vendor_name))))) as vendor_second_word
FROM vendors;
SELECT vendor_name,
		UPPER(vendor_name),
        vendor_phone,
       SUBSTRING(vendor_phone,11) as vendor_last_4,
       CONCAT(SUBSTRING(vendor_phone,2,3), ".", SUBSTRING(vendor_phone,7,3), ".",SUBSTRING(vendor_phone,11)) as vendor_phone_2,
      SUBSTRING(vendor_name, LOCATE(' ' , vendor_name),LOCATE(' ', LTRIM(SUBSTRING(vendor_name, LOCATE(' ' , vendor_name))))) as vendor_second_word
FROM vendors;

SELECT	invoice_number,
		invoice_date,
		DATE_ADD(invoice_date, INTERVAL 30 DAY) as invoice_date_add_30_days,
        payment_date,
        DATEDIFF(payment_date , invoice_date) as days_to_pay,
		MONTH(invoice_date) as invoice_date_month,
        YEAR(invoice_date) as invoice_date_year
FROM invoices
WHERE LOCATE('May', DATE_FORMAT(invoice_date, '%M')) != 0;