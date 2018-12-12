-- # Trevor J Pucket
-- # 10/15/2018
-- # Exercise 05 -- CPT 242

#1
INSERT INTO terms
	(terms_id,terms_description,terms_due_days)
VALUES (6,"Net due 120 days",120);
#2
UPDATE terms
SET terms_description = "Net due 125 days",
    terms_due_days = 125
WHERE terms_id = 6;
#3
DELETE FROM terms
WHERE terms_id = 6;
#4
INSERT INTO invoices 
VALUES(default, 32, "AX-014-027",'2014-08-1',434.58,0,0,2,'2014-08-31',null);
#5
INSERT INTO invoice_line_items
VALUES (115, 1, 160, 180.23,"Hard drive"), (115, 2, 160, 180.23, "Exchange Server update");
#6
UPDATE invoices
SET credit_total = (invoice_total * .1),
    payment_total = (invoice_total - credit_total)
WHERE invoice_id = 115;
#7
UPDATE vendors
SET default_account_number = 403
WHERE vendor_id = 44;
#8
UPDATE invoices
SET terms_id = 2
WHERE vendor_id IN(SELECT vendor_id
		   FROM vendors
		   WHERE default_terms_id = 2);
#9
DELETE FROM invoice_line_items 
WHERE invoice_id = 115;
DELETE FROM invoices
WHERE invoice_id = 115;