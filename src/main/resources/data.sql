INSERT INTO car (license_plate, repair_date , customer_name           , catalog          , car_maker)
VALUES          ('36V7-65366' , '2003-11-16', 'Tô Thị Lâm'            , 'Bảo dưỡng lần 2', 'Honda'  ),
                ('29V7-65366' , '2003-11-16', 'Nguyễn Ngọc Minh Trang', 'Bảo dưỡng lần 1', 'Honda'  ),
                ('29H1-15840' , '2023-05-19', 'Lê Bảo Bình'           , 'Bảo dưỡng lần 8', 'Vinfast'),
                ('29E1-88888' , '2019-04-07', 'Nguyễn Thị Thái Hà'    , 'Bảo dưỡng lần 2', 'BMW'    ),
                ('29B1-66666' , '2015-07-29', 'Vũ Đức Long'           , 'Bảo dưỡng lần 6', 'Nissan' ),
                ('29V7-52143' , '2021-03-05', 'Nguyễn Văn Khoa'       , 'Bảo dưỡng lần 4', 'Toyota' );

INSERT INTO accessory (license_plate, repair_date , name         , price  , status_damaged, repair_status)
VALUES                ('29V7-52143' , '2021-03-05', 'Kính'       , 900000 , 'Bị vỡ'       , 'Thay mới'   ),
                      ('29V7-52143' , '2021-03-05', 'Cần gạt mưa', 999000 , 'Bị gãy'      , 'Thay mới'   ),
                      ('29V7-65366' , '2003-11-16', 'Lọc gió'    , 199000 , 'Bị bụi bẩn'  , 'Làm sạch'   ),
                      ('36V7-65366' , '2003-11-16', 'Lốp xe'     , 2000000, 'Bị thủng'    , 'Thay lốp'   ),
                      ('29V7-65366' , '2003-11-16', 'Bình ắc quy', 1465000, 'Bị hết điện' , 'Sạc điện'   ),
                      ('29V7-65366' , '2003-11-16', 'Đèn xe'     , 369000 , 'Bị vỡ'       , 'Thay đèn'   );