INSERT INTO "ADDRESS" (ID, LINE1, LINE2, ZIP_CODE, CITY, STATE, COUNTRY, CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE, DELETED) VALUES(hibernate_sequence.nextval, 'sea link road', null, '18017', null, 'UP', 'India', 'system', sysdate, null, null, 0);
INSERT INTO "ADDRESS" (ID, LINE1, LINE2, ZIP_CODE, CITY, STATE, COUNTRY, CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE, DELETED) VALUES(hibernate_sequence.nextval, 'willa road', 'rest', '18017', null, 'UP', 'India', 'system', sysdate, null, null, 0);


INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, PHONE, ADDRESS_ID, CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE, DELETED) VALUES(hibernate_sequence.nextval, 'amit','111@yahoo.com', '9089788990', 1, 'system', sysdate, null, null, 0);
INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, PHONE, ADDRESS_ID, CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE, DELETED) VALUES(hibernate_sequence.nextval, 'kishan','222@yahoo.com', '9089907889', 1, 'system', sysdate, null, null, 0);
INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, PHONE, ADDRESS_ID, CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE, DELETED) VALUES(hibernate_sequence.nextval, 'varsha','333@yahoo.com', '6789907890', 2, 'system', sysdate, null, null, 0);


