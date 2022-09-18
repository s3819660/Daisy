USE heroku_5bb85fc4365f379;

INSERT INTO customer(id, cutomer_address, cutomer_name)
VALUES
       (0, '1 Nguyen Trai Ward 2, District 5', 'Coconut'),
       (1,'702 Nguyen Van Linh, Ward Tan Phong , District 7','RMIT'),
       (2, 'Han Thuyen Street, khu phố 6 P, Thu Duc, Ho Chi Minh City', 'UIT'),
       (3, '364 Cong Hoa Street, Ward 13, District Tan Binh, Thanh pho Ho Chi Minh', 'Bosch'),
       (4, 'VTC Academy', 'SheCodes'),
       (5, '5 3/2 Street, Ward 12, District 11', 'Romeo'),
       (6, '129 Nguyen Trai Street, Ward 2, District 5', 'Juliet'),
       (7, '106 Hai Bà Trưng, Đa Kao, Quận 1, Thành phố Hồ Chí Minh', 'Bao Bao'),
       (8, '71 Đ. Trần Hưng Đạo, Phường Cầu Ông Lãnh, Quận 1, Thành phố Hồ Chí Minh', 'Tieu La'),
       (9, '175 Pham Hung, Phường 4, Quận 8, Thành phố Hồ Chí Minh 700000', 'An Khang');

INSERT INTO restaurant(id, address, restaurant_name)
VALUES
        (0, '212A/A37 Nguyễn Trãi, P. Nguyễn Cư Trinh, Quận 1, TP. HCM', 'Emy - Trái Cây Tươi Và Ăn Vặt'),
        (1, '76 Hai Ba Trung Street, District 1, Ho Chi Minh', 'An Vat tuoi vui'),
        (2, '58/11 Nguyễn Văn Săng, P. Tân Sơn Nhì, Tân Phú, TP. HCM', 'A Chảy - Mì Sủi Cảo & Cơm Chiên Gà Xối Mỡ'),
        (3, '134 - 136 Hồng Bàng, P. 12, Quận 5, TP. HCM', 'KAI Coffee'),
        (4, '80C Đường Số 49, P. Tân Quy, Quận 7, TP. HCM', 'Hello Burger - Hamburger & Chicken'),
        (5, '73/5A Tân Hải, P. 13, Tân Bình, TP. HCM', 'Cô Loan - Cháo Sườn - Tân Hải'),
        (6, '38 Cầu Xéo, P. Tân Quý, Tân Phú, TP. HCM', 'Súp Cua Xuân Lan - Cầu Xéo'),
        (7, '66 Út Tịch, P. 4, Tân Bình, TP. HCM', 'Bánh Mì PewPew - Út Tịch'),
        (8, '149A Xóm Đất, P. 9, Quận 11, TP. HCM', 'Há Cảo Kiều Ký'),
        (9, '66 Út Tịch, P. 4, Tân Bình, TP. HCM', 'Mì Ý Mẹ Ri');

INSERT INTO shipper(id, shipper_name)
VALUES
        (0, 'Dinh Bang Son'),
        (1, 'Doan Van Hau'),
        (2, 'Nguyen Van A'),
        (3, 'Hello World'),
        (4, 'Nguyen Cong Tru'),
        (5, 'Tommy Huynh'),
        (6, 'Phuong Gia My'),
        (7, 'Mai Nhu Anh'),
        (8, 'Tran Gia Tuan'),
        (9, 'Dao Ba Tung');

INSERT INTO orders(id, amount, date, total, customer_id, restaurant_id, shipper_id, mark_completed, mark_get_food)
VALUES
        (0, 87000, '1/10/2022', 87000, 6, 3, 3, true, true),
        (1, 0, '1/10/2022', 75000, 1, 5, 4, true, true),
        (2, 85000, '1/10/2022', 100000, 5, 3, 6, true, true),
        (3, 0, '1/10/2022', 75000, 9, 3,  null, false, false),
        (4, 355000, '1/10/2022', 355000, 8, 4, null, false, false),
        (5, 134000, '1/10/2022', 355000, 2, 4, null, false, false),
        (6, 0, '1/10/2022', 273000, 7, 4, null, false, false),
        (7, 0, '1/10/2022', 23000, 3, 8, null, false, false),
        (8, 100000, '1/10/2022', 178000, 1, 2, null, false, false),
        (9, 89000, '1/10/2022', 101000, 6, 9, null, false, false);


