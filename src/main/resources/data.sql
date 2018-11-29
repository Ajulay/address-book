INSERT INTO country(
          id, "name", code)
	VALUES (1, 'Россия', '643');

INSERT INTO country(
          id, "name", code)
	VALUES (2, 'Армения', '051');

INSERT INTO country(
          id, "name", code)
	VALUES (3, 'Казахстан', '398');

INSERT INTO country(
          id, "name", code)
	VALUES (4, 'Германия', '276');

INSERT INTO country(
          id, "name", code)
	VALUES (5, 'Таджикистан', '762');

INSERT INTO country(
          id, "name", code)
	VALUES (6, 'Сербия', '688');


INSERT INTO doc(
          id, "name", code)
	VALUES (1, 'паспорт гражданина РФ', '21');

INSERT INTO doc(
          id, "name", code)
	VALUES (2, 'свидетельство о рождении', '3');

INSERT INTO doc(
          id, "name", code)
	VALUES (3, 'паспорт иностранного гражданина', '10');

INSERT INTO doc(
          id, "name", code)
	VALUES (4, 'вид на жительство РФ', '12');

INSERT INTO doc(
          id, "name", code)
	VALUES (5, 'Свидетельство о предоставлении временного убежища РФ', '18');

INSERT INTO organization(
          name, fullname, inn, kpp, address, phone, active)
	VALUES ('MTS', 'Mobile TeleSystem', '11111111', '0011111100', 'Moscow', '8-800-000-88-77', true);

INSERT INTO organization(
          name, fullname, inn, kpp, address, phone, active)
	VALUES ('Beeline', 'Beeline ltd', '22222222', '0044444400', 'StPeterburg', '8-800-000-33-77', true);

INSERT INTO organization(
          name, fullname, inn, kpp, address, phone, active)
	VALUES ('Megafone', 'Megafone ltd', '33333333', '00555555500', 'Samara', '8-800-000-33-55', true);

INSERT INTO organization(
          name, fullname, inn, kpp, address, phone, active)
	VALUES ('MTS', 'Mobile TeleSystem fake', '11aaaaaa11', '00bbbbbb00', 'MoscowMoscow', '8-900-900-88-77', false);

INSERT INTO organization(
          name, fullname, inn, kpp, address, phone, active)
	VALUES ('Beeline', 'Beeline fake', '22aaaaa2', '00444bb400', 'StPeterburgka', '8-900-900-33-77', false);

INSERT INTO organization(
          name, fullname, inn, kpp, address, phone, active)
	VALUES ('Megafone', 'Megafone fake', '3aaa3', '005bbbb0', 'Samarka', '8-900-900-33-55', false);


INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('mts-1', 'ЮЗАО', '8-800-000-11-11', 1, true);

INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('mts-2', 'САО', '8-800-000-11-22', 1, true);

INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('mts-3', 'СВАО', '8-800-000-11-33', 1, true);

INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('beeline-1', 'ЮЗАО', '8-800-000-22-11', 2, true);

INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('beeline-2', 'САО', '8-800-000-22-22', 2, true);

INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('beeline-3', 'СВАО', '8-800-000-22-33', 2, true);

INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('megafone-1', 'ЮЗАО', '8-800-000-33-11', 3, true);

	INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('megafone-2', 'САО', '8-800-000-33-22', 3, true);

INSERT INTO office(
	        name, address, phone, organization_id, active)
	VALUES ('megafone-3', 'СВАО', '8-800-000-33-33', 3, true);


INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (1, 'Иванов', 'Иван', 'Иванович', 'директор', '8-100-000-000-1', true, '60 00 000001', '2000-01-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (1, 'Петров', 'Иван', 'Иванович', 'заместитель директора', '8-100-000-000-2', true,  '60 00 000002', '2000-02-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (1, 'Иванов', 'Петр', 'Иванович', 'главный бухгалтер', '8-100-000-000-3', true,  '60 00 000003', '2000-03-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (2, 'Сидоров', 'Сидор', 'Иванович', 'завхоз', '8-100-000-000-4', true, '60 00 000004', '2000-04-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (2, 'Марков', 'Иван', 'Маркович', 'Старший менеджер', '8-100-000-000-5', true,  '60 00 000005', '2000-05-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (2, 'Добрый', 'Вечер', 'Семенович', 'Старший менеджер', '8-100-000-000-6', true, '60 00 000006', '2000-06-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (3, 'Семенов', 'Семен', 'Семенович', 'Старший менеджер', '8-100-000-000-7', true, '60 00 000007', '2000-07-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (3, 'Семенов', 'Иван', 'Семенович', 'юнга(стажер)', '8-100-000-000-1', true, 'IO-VII 00 000010', '2005-01-01', 2, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (3, 'Манукян', 'Овик', 'Ашотович', 'стилист', '8-100-000-010-1', true,  'AM  0000011', '2008-01-01', 3, 2);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (4, 'Тырин', 'Юрий', 'Иванович', 'директор', '8-100-000-100-1', true, '60 00 001001', '2010-01-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified,  doc_number, doc_date, doc_id, country_id)
	VALUES (4, 'Пузырев', 'Тимофей', 'Иванович', 'заместитель директора', '8-100-080-000-1', true, '60 00 110001', '2011-01-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (4, 'Назарбаев', 'Назар', 'Мулдыбаевич', 'грузчик-кассир', '8-100-110-000-1', true, '60 000001', '2016-01-01', 4, 3);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (5, 'Римский', 'Сергей', 'Иванович', 'директор', '8-100-000-000-9', true, '60 00 009901', '2004-11-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (5, 'Абрамян', 'Роман', 'Давлетович', 'заместитель директора', '8-100-007-000-1', true, 'АМ 8000001', '2015-12-01', 3, 2);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (5, 'Бенедиктов', 'Бенедикт', 'Иванович', 'продавец', '8-100-000-001-1', true, '40 10 000001', '2005-10-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (6, 'Рахматов', 'Анвар', 'Иванович', 'директор', '8-100-000-090-1', true, 'А 090001', '2016-07-01', 3, 5);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (6, 'Гирман', 'Фриц', 'Адольф', 'заместитель директора', '8-100-000-111-1', true, 'Z 11000001', '2017-08-10', 3, 4);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (6, 'Миляев', 'Семен', 'Петрович', 'главный бухгалтер', '8-111-000-000-1', true, '80 00 000001', '2002-01-02', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (7, 'Яев', 'Мил', 'Святович', 'директор', '8-900-000-000-1', true, 'АА 0000001', '2018-01-01', 5, 6);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (7, 'Косова', 'Людмила', 'Петровна', 'заместитель директора', '8-100-999-000-1', true, '10 10 000010', '2010-10-10', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (7, 'Иванова', 'Нааталья', 'Ивановна', 'главный бухгалтер', '8-100-000-888-1', true, '50 08 000001', '2008-08-01', 1, 1);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (8, 'Геббельс', 'Генрих', 'Иванович', 'директор', '8-100-000-000-1', true, '60 00 000001', '2014-05-01', 3, 4);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified,  doc_number, doc_date, doc_id, country_id)
	VALUES (8, 'Геринг', 'Марк', 'Абросович', 'заместитель директора', '8-100-234-000-1', true, 'Z 99000001', '2014-06-21', 3, 4);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (8, 'Брут', 'Александр', 'Утыкаевич', 'Старший менеджер', '8-100-010-010-1', true, 'Z 11000009', '2015-11-11', 3, 4);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (9, 'Муродов', 'Ислам', 'Аллахович', 'продавец', '8-100-700-700-1', true, '60 000001', '2017-04-11', 4, 5);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (9, 'Геворкян', 'Инна', 'Петровна', 'главный бухгалтер', '8-100-000-888-1', true,  '60  000004', '2016-04-21', 4, 2);

INSERT INTO "user"(
	         office_id, first_name, second_name, middle_name, pozition, phone, identified, doc_number, doc_date, doc_id, country_id)
	VALUES (9, 'Лесов', 'Антон', 'Павлович', 'директор', '8-177-777-000-1', true, '70 07 000007', '2007-07-07', 1, 1);

