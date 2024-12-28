use real_estate;

INSERT INTO role (roleName, description)
VALUES 
('Manager', 'Quản lý'),
('Sales', 'Nhân viên'),
('Lessor', 'Chủ nhà'),
('Lessee', 'Người thuê nhà');

INSERT INTO employee (lastName, firstName, email, gender, dateOfBirth, address, phoneNumber)
VALUES
	('Nguyễn Văn', 'Anh', 'nguyenvananh@example.com', 'Male', '1990-01-21', '123 Đường Mã Lò, Quận Bình Tân, Thành phố Hồ Chí Minh', '0912345678'),
    ('Trần Thị', 'Mai', 'tranthimai@example.com', 'Female', '1991-02-14', '456 Đường Lê Lợi, Quận 2, Thành phố Hồ Chí Minh', '0912345679'),
    ('Lê Ngọc', 'Hùng', 'lengochung@example.com', 'Male', '1992-03-23', '789 Đường Trần Quốc Toản, Quận 3, Thành phố Hồ Chí Minh', '0912345680');
    
INSERT INTO lessor (lastName, firstName, email, address, phoneNumber)
VALUES   
    ('Hoàng Ngọc', 'Linh', 'hoangngoclinh@example.com', '1011 Đường Điện Biên Phủ, Quận 4, Thành phố Hồ Chí Minh', '0912345681'),
    ('Phạm Minh', 'Đức', 'phamminhduc@example.com', '1213 Đường Pasteur, Quận 5, Thành phố Hồ Chí Minh', '0912345682'),
    ('Bùi Thị', 'Thu', 'buithithu@example.com', '1415 Đường Trần Hưng Đạo, Quận 6, Thành phố Hồ Chí Minh', '0912345683'),
    ('Tiêu Anh', 'Tuấn', 'tieuanhtuan@example.com', '1617 Đường Nguyễn Thiện Thuật, Quận 7, Thành phố Hồ Chí Minh', '0912345684'),
    ('Dương Ngọc', 'Châu', 'duongngocchau@example.com', '1819 Đường Hoàng Diệu, Quận 8, Thành phố Hồ Chí Minh', '0912345685'),
    ('Đỗ Văn', 'Kiên', 'dovankien@example.com', '2021 Đường Nguyễn Văn Cừ, Quận 9, Thành phố Hồ Chí Minh', '0912345686'),
    ('Vũ Hỷ', 'Phương', 'vuhyphuong@example.com', '2223 Đường Nguyễn Hữu Tháp, Quận 10, Thành phố Hồ Chí Minh', '0912345687');
    
INSERT INTO account (username, password, roleID, employeeID, lessorID)
VALUES
    ('nguyenvananh', '123', 1, 1, null),
    ('tranthimai', '123', 2, 2, null),
    ('lengochung', '123', 2, 3, null),

    ('hoangngoclinh', '123', 3, null, 1),
    ('phamminhduc', '123', 3, null, 2),
    ('buithithu', '123', 3, null, 3),
    ('tieuanhtuan', '123', 3, null, 4),
    ('duongngocchau', '123', 3, null, 5),
    ('dovankien', '123', 3, null, 6),
    ('vuhyphuong', '123', 3, null, 7);
    
INSERT INTO AccomType (type, description)
VALUES
	('Apartment', 'Căn hộ chung cư'),	
    ('Studio', 'Căn hộ nhỏ, có phòng ngủ và phòng khách kết hợp'),	
    ('Villa', 'Biệt thự, nhà riêng cao cấp'),	
    ('House', 'Nhà ở, có nhiều phòng'),	
	('Room', 'Phòng riêng chung nhà');
    
INSERT INTO Advantage (code, description, accomTypeID)
VALUES
	('Tiện ích đa dạng', 'Thường đi kèm với nhiều tiện ích như hồ bơi, phòng gym, khu vui chơi trẻ em, siêu thị mini, bảo vệ 24/7... giúp bạn tận hưởng cuộc sống tiện nghi.', 1),	
    ('Vị trí trung tâm', 'Căn hộ thường nằm ở các khu vực trung tâm thành phố, gần các tiện ích công cộng, thuận tiện cho việc đi làm, đi học và sinh hoạt.', 1),	
    ('An ninh tốt', 'Được quản lý bởi ban quản lý tòa nhà, hệ thống an ninh được đảm bảo, giúp bạn yên tâm sinh sống.', 1),	
    ('Đa dạng thiết kế', 'Có nhiều loại căn hộ khác nhau về diện tích, số phòng, phong cách thiết kế, phù hợp với nhiều nhu cầu và khả năng tài chính.', 1),	
	('Giá cả hợp lý', ' So với nhà phố, giá căn hộ thường mềm hơn, phù hợp với nhiều đối tượng khách hàng.', 1),
    
	('Không gian mở', 'Kết hợp phòng khách, phòng ngủ và bếp thành một không gian mở, tạo cảm giác rộng rãi và hiện đại.', 2),	
    ('Giá cả phải chăng', 'Diện tích nhỏ gọn nên giá thành thường thấp hơn so với các loại căn hộ khác.', 2),	
    ('Phù hợp với người độc thân hoặc cặp đôi trẻ', 'Thích hợp cho những người sống độc lập hoặc các cặp đôi trẻ, không cần quá nhiều không gian.', 2),	
    ('Dễ dàng trang trí', 'Với không gian mở, bạn có thể dễ dàng trang trí và sắp xếp nội thất theo ý thích.', 2),	
	('Tiết kiệm chi phí', 'Giảm thiểu chi phí xây dựng và nội thất.', 2),
    
	('Không gian sống rộng rãi', 'Diện tích lớn, nhiều phòng, sân vườn rộng rãi, tạo cảm giác thoải mái và riêng tư.', 3),	
    ('Thiết kế sang trọng', 'Thường được thiết kế theo phong cách hiện đại hoặc cổ điển, mang đến vẻ đẹp đẳng cấp.', 3),	
    ('Môi trường sống trong lành', 'Thường nằm ở các khu vực ngoại ô, gần gũi với thiên nhiên, không khí trong lành.', 3),	
    ('Tính riêng tư cao', 'Mỗi biệt thự thường có một khuôn viên riêng, đảm bảo sự riêng tư cho gia đình.', 3),	
	('Giá trị đầu tư cao', 'Biệt thự thường có giá trị tăng theo thời gian, là một kênh đầu tư hấp dẫn.', 3),
    
	('Vị trí thuận tiện', 'Thường nằm ở các khu dân cư đông đúc, gần các tiện ích công cộng.', 4),	
    ('Tính kết nối cao', 'Dễ dàng di chuyển đến các khu vực khác trong thành phố.', 4),	
    ('Không gian sống linh hoạt', 'Có thể thiết kế và cải tạo theo ý thích.', 4),	
    ('Phù hợp với nhiều đối tượng', 'Từ gia đình trẻ đến người lớn tuổi.', 4),	
	('Giá cả đa dạng', 'Có nhiều mức giá khác nhau, phù hợp với nhiều khả năng tài chính.', 4),
    
	('Giá cả phải chăng', 'Thường có giá thuê rất rẻ, phù hợp với sinh viên, người đi làm có thu nhập thấp.', 5),	
    ('Linh hoạt', 'Hợp đồng thuê thường ngắn hạn, dễ dàng chuyển đi khi cần.', 5),	
    ('Tiện ích cơ bản', 'Đáp ứng các nhu cầu sinh hoạt cơ bản như nấu ăn, ngủ nghỉ.', 5),	
    ('Dễ dàng tìm kiếm', 'Có rất nhiều phòng trọ trên thị trường.', 5),	
	('Môi trường sống đa dạng', 'Có cơ hội làm quen và giao lưu với nhiều người từ khắp nơi, tạo ra một môi trường sống đa dạng và sôi động.', 5);

INSERT INTO Accommodation (map, accommodationName, street, ward, district, city, direction, size, numberOfRooms, lessorID, salesID, accomTypeID,image)
VALUES
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.484176766535!2d106.70150507407003!3d10.774180259237145!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f46eba57597%3A0xbc997cf33696e51!2zNDYgTmd1ecOqzINuIEh1w6rMoywgQuG6v24gTmdow6ksIFF14bqtbiAxLCBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1735412557733!5m2!1svi!2s', 'The Elysian', '46 Nguyễn Huệ', 'Bến Nghé', 'Quận 1', 'Hồ Chí Minh', 'Nam', 75.00, 2, 1, 2, 1,"Apartment_1.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.252845884821!2d106.71428471803665!3d10.806470711229393!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175271387942353%3A0x70bd7e7d0f21412e!2zVGjhuqNvIMSRaeG7gW4!5e0!3m2!1svi!2s!4v1735412821828!5m2!1svi!2s', 'Azure Skies', '123 Thảo Điền', 'An Thú', 'Quận 2', 'Hồ Chí Minh', 'Đông', 40.00, 1, 3, 2, 2,"Studio_1.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.972545196753!2d106.71882887406957!3d10.736599359929068!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f87a507f94d%3A0x2ea7ebb05e572189!2zMjI1IMSQLiBOZ3V54buFbiBWxINuIExpbmgsIFTDom4gUGjDuiwgUXXhuq1uIDcsIEjhu5MgQ2jDrSBNaW5oLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1735412890938!5m2!1svi!2s', 'The Haven', '225 Nguyễn Văn Linh', 'Tân Phú', 'Quận 7', 'Hồ Chí Minh', 'Nam', 250.00, 5, 3, 2, 3,"Villa_1.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.5026318616583!2d106.68628367407!3d10.772762459263268!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f3cafc429fb%3A0x640a76c714c7915b!2zNzkgxJAuIE5ndXnhu4VuIFRo4buLIE1pbmggS2hhaSwgUGjGsOG7nW5nIFBo4bqhbSBOZ8WpIEzDo28sIFF14bqtbiAxLCBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1735412968840!5m2!1svi!2s', 'The Grandiose', '79 Nguyễn Thị Minh Khai', '6', 'Quận 3', 'Hồ Chí Minh', 'Bắc', 120.00, 3, 3, 2, 4,"House_1.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15677.276230313542!2d106.67307951914017!3d10.786857232693393!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f33a9c64005%3A0x4b99df22fa14dfdc!2zODggUGjhuqFtIE5n4buNYyBUaOG6oWNoLCBQaMaw4budbmcgNiwgUXXhuq1uIDMsIEjhu5MgQ2jDrSBNaW5oLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1735413135230!5m2!1svi!2s', 'The Pinnacle', '88 Phạm Ngọc Thạch', 'Phú Nhuận', 'Quận 5', 'Hồ Chí Minh', 'Tây', 30.00, 1, 5, 2, 5,"Room_1.jpg"),
	
    ('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.076388727093!2d105.84773267428955!3d21.029629287750634!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9516e29813%3A0xbbe54d43df3ea9fd!2zUC4gSMOgbmcgVHLhu5FuZywgSG_DoG4gS2nhur9tLCBIw6AgTuG7mWksIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1735413223375!5m2!1svi!2s', 'The Willow Creek', 'Phố Hàng Trọng', 'Hàng Trọng', 'Hoàn Kiếm', 'Hà Nội', 'Bắc', 60.00, 2, 2, 3, 1,"Apartment_2.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.6581997192193!2d105.83662307429012!3d21.046358037175796!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abae355e783b%3A0xaba35647249853b5!2zaOG7kyBUcsO6YyBC4bqhY2g!5e0!3m2!1svi!2s!4v1735413320919!5m2!1svi!2s', 'Ocean Breeze', 'Hồ Trúc Bạch', 'Trúc Bạch', 'Tây Hồ', 'Hà Nội', 'Tây', 45.00, 1, 6, 3, 2,"Studio_2.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.3339972463746!2d105.84387737428932!3d21.019317888104652!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab920789b57f%3A0x8ef65573d77ebc94!2zUC4gTmd1eeG7hW4gRHUsIEhhaSBCw6AgVHLGsG5nLCBIw6AgTuG7mWksIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1735413449500!5m2!1svi!2s', 'The Forest Retreat', '1162 Nguyễn Du', 'Đống Đa', 'Đống Đa', 'Hà Nội', 'Nam', 180.00, 4, 4, 3, 3,"Villa_2.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.5532011043338!2d105.80234157429018!3d21.05055628703146!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab227220aea9%3A0x200fd61c26f56112!2zODAgxJAuIFbDtSBDaMOtIEPDtG5nLCBOZ2jEqWEgxJDDtCwgQ-G6p3UgR2nhuqV5LCBIw6AgTuG7mWksIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1735413519342!5m2!1svi!2s', 'Mountain View', '80 Võ Chí Công', 'Cửa Lò', 'Bắc Từ Liêm', 'Hà Nội', 'Đông', 100.00, 3, 4, 3, 4,"House_2.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.7469447606177!2d105.81923447428875!3d21.002778588672257!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ac8442238db9%3A0x29993d1255dc4355!2zNjM4IMSQLiBUcsaw4budbmcgQ2hpbmgsIE5nw6MgVMawIFPhu58sIMSQ4buRbmcgxJBhLCBIw6AgTuG7mWksIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1735413580144!5m2!1svi!2s', 'The Sunnyside', '638 Trường Chinh', 'Thanh Xuân Trung', 'Thanh Xuân', 'Hà Nội', 'Nam', 25.00, 1, 7, 3, 5,"Room_2.jpg"),
	
    ('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15339.166457618148!2d108.23826152894499!3d16.024359735950753!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314217496cf76927%3A0x47dff6e31a2ac7a0!2zOTgwIFbDtSBOZ3V5w6puIEdpw6FwLCBLaHXDqiBN4bu5LCBOZ8WpIEjDoG5oIFPGoW4sIMSQw6AgTuG6tW5nLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1735413646117!5m2!1svi!2s', 'The Wanderlust', '980 Võ Nguyên Giáp', 'Khai Hương', 'Ngũ Hành Sơn', 'Đà Nẵng', 'Đông', 80.00, 2, 7, 3, 1,"Apartment_3.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3835.223999719333!2d108.26436867416122!3d16.001850741240137!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314210c6744baf55%3A0x4056c30178a04e63!2zNzYgVHLGsOG7nW5nIFNhLCBIb8OgIEjhuqNpLCBOZ8WpIEjDoG5oIFPGoW4sIMSQw6AgTuG6tW5nIDU1MDAwMCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1735413701975!5m2!1svi!2s', 'The Nomad', '76 Trường Sa', 'An Hải Bắc', 'Sơn Trà', 'Đà Nẵng', 'Nam', 35.00, 1, 5, 3, 2,"Studio_3.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.95066250702!2d108.20759917416261!3d16.068049839471417!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142184ba657133d%3A0x9ba5024078b6e0fd!2zOTAgSG_DoG5nIEhvYSBUaMOhbSwgVMOibiBDaMOtbmgsIFRoYW5oIEtow6osIMSQw6AgTuG6tW5nIDU1MDAwMCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1735413740324!5m2!1svi!2s', 'The Eccentric', '90 Hoàng Hoa Thắm', 'Thanh Khê Tây', 'Thanh Khê', 'Đà Nẵng', 'Bắc', 200.00, 4, 4, 3, 3,"Villa_3.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d122653.30783813169!2d108.07196451098021!3d16.121652364461436!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142198a7bd5644f%3A0xd181a378b8667b5e!2z4bqobSB0aOG7sWMgVHLhuqduIC0gMTEgTmd1eeG7hW4gVsSDbiBMaW5oLCDEkMOgIE7hurVuZw!5e0!3m2!1svi!2s!4v1735413826492!5m2!1svi!2s', 'The Bohemian', '11 Nguyễn Văn Linh', 'Liên Chiều', 'Liên Chiều', 'Đà Nẵng', 'Tây', 150.00, 3, 1, 3, 4,"House_3.jpg"),
	('https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15336.659490622988!2d108.20867234578634!3d16.056931933958328!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314219b5d15102ef%3A0x267dee2288d4ad5c!2zxJAuIE5ndXnhu4VuIFbEg24gTGluaCwgxJDDoCBO4bq1bmcgNTUwMDAwLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1735413921579!5m2!1svi!2s', 'The Enigma', '912 Nguyễn Văn Linh', 'Cẩm Lệ', 'Cẩm Lệ', 'Đà Nẵng', 'Đông', 20.00, 1, 3, 3, 5,"Room_3.jpg");

INSERT INTO Amenity (amenityName, description)
VALUES
	('Interior', 'Nội thất'),
    ('Swimming Pool', 'Hồ bơi'),
    ('Gym', 'Phòng tập gym'),
    ('Spa', 'Spa, xông hơi'),
    ('Restaurant', 'Nhà hàng'),
    ('Bar', 'Quầy bar'),
    ('Wifi', 'Wifi miễn phí'),
    ('Parking', 'Chỗ đậu xe'),
    ('Laundry Service', 'Dịch vụ giặt ủi'),
    ('Concierge Service', 'Dịch vụ lễ tân'),
    ('Room Service', 'Phục vụ phòng');

INSERT INTO RentType (rentTypeName, description)
VALUES
	('Yearly', 'Thuê theo năm'),
    ('Seasonal', 'Thuê theo mùa'),
    ('Monthly', 'Thuê theo tháng'),
    ('Daily', 'Thuê theo ngày'),
    ('Weekly', 'Thuê theo tuần'),
    ('Hourly', 'Thuê theo giờ');
    
INSERT INTO DetailAmenity (accommodationID, amenityID)
VALUES
    (1, 1), (1, 2), (1, 3), (1, 7), (1, 8), (1, 10),
    (2, 1), (2, 7), (2, 8),
    (3, 1), (3, 2), (3, 6), (3, 7), (3, 8), (3, 9), (3, 10), (3, 11),
    (4, 1), (4, 7),
    (5, 1), (5, 7), (5, 8), (5, 10),
    
	(6, 2), (6, 3), (6, 8), (6, 10),
    (7, 1), (7, 7), (7, 8),
    (8, 1), (8, 2), (8, 3), (8, 4), (8, 6), (8, 7), (8, 8), (8, 9), (8, 10), (8, 11),
    (9, 1),
    (10, 8), (10, 10),
    
	(11, 1), (11, 3), (11, 7), (11, 8), (11, 10),
    (12, 1), (12, 7), (12, 8),
    (13, 1), (13, 2), (13, 3), (13, 6), (13, 7), (13, 8), (13, 9), (13, 10), (13, 11),
    (14, 2),
    (15, 1), (15, 7), (15, 8);

--------------------------------------------------------------------------------------------
INSERT INTO DetailRentType (accommodationID, rentTypeID, price, deposit)
VALUES
	(1, 1, 180000000, 50000000), (1, 2, 45000000, 15000000), (1, 3, 15000000, 5000000),
    
    (2, 4, 800000, 200000), (2, 6, 100000, 30000),
    
	(3, 1, 360000000, 100000000), (3, 2, 90000000, 30000000), (3, 3, 30000000, 10000000),
    (3, 4, 2000000, 500000), (3, 5, 8000000, 2000000),
    
	(4, 1, 240000000, 60000000), (4, 2, 60000000, 20000000), (4, 3, 20000000, 5000000),
    
    (5, 1, 120000000, 30000000), (5, 2, 30000000, 10000000), (5, 3, 10000000, 3000000),
    (5, 4, 1000000, 300000), (5, 5, 3000000, 1000000), (5, 6, 200000, 50000),
    
	(6, 1, 150000000, 40000000), (6, 2, 40000000, 10000000), (6, 3, 12000000, 4000000), 
    
    (7, 4, 700000, 200000), (7, 6, 80000, 30000), 
    
	(8, 1, 300000000, 80000000), (8, 2, 75000000, 25000000), (8, 3, 25000000, 8000000), 
    (8, 4, 1800000, 500000), (8, 5, 7000000, 2000000),
    
	(9, 1, 180000000, 45000000), (9, 2, 50000000, 15000000), (9, 3, 15000000, 5000000),  
    
	(10, 1, 100000000, 25000000), (10, 2, 25000000, 8000000), 
    (10, 3, 8000000, 2000000), (10, 4, 800000, 200000), (10, 5, 2500000, 600000), (10, 6, 150000, 50000),
    
    (11, 1, 20000000, 6000000), (11, 2, 9000000, 3000000), (11, 3, 7000000, 2000000),
    
    (12, 4, 600000, 150000), (12, 6, 80000, 20000),
    
    (13, 1, 50000000, 15000000), (13, 2, 20000000, 6000000), (13, 3, 10000000, 3000000),
    (13, 4, 1200000, 300000), (13, 5, 800000, 200000),
    
    (14, 1, 22000000, 7000000), (14, 2, 10000000, 3000000), (14, 3, 5000000, 1500000),
    
    (15, 1, 12000000, 4000000), (15, 2, 6000000, 2000000), (15, 3, 4000000, 1200000),
    (15, 4, 1000000, 300000), (15, 5, 900000, 250000), (15, 6, 600000, 150000);
--------------------------------------------------------------------------------------------


use real_estate;

select * from Accommodation order by accommodationID DESC;
select * from DetailRentType order by accommodationID DESC;
select * from AccomType;
-- --pass:123;-- 
select * from Account; 
select * from Advantage;
select * from Amenity;
select * from DetailAmenity;
select * from Invoice;
select * from Lessee;
select * from Lessor;
select * from Payment;
select * from RentType;
select * from Reservation;
select * from Role;
select * from employee;

select * from reservation join accommodation on accommodation.accommodationID =  reservation.accommodationID where salesID = 3;

select *
from User join Account on User.userID = Account.userID
			join Role on Role.roleID = Account.roleID
where Role.roleID = '1';

select * 
from accommodation join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID;

select accommodation.accommodationID, accommodationName, amenityName
from accommodation join detailamenity on accommodation.accommodationID = detailamenity.accommodationID
					join amenity on detailamenity.amenityID = amenity.amenityID;
                    
select accommodation.accommodationID, accommodationName, rentTypeName
from accommodation join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID
					join renttype on detailrenttype.renttypeID = renttype.renttypeID;
                    
select * from accommodation  join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID;

select * 
from accommodation  join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID 
                    join renttype on detailrenttype.renttypeID = renttype.renttypeID
 where 1 = 1  AND rentTypeName IN ("Yearly", 'Daily');
 
 select amenityName from amenity join detailamenity on amenity.amenityID = detailamenity.amenityID
 where accommodationID = 1;
 
--  select *
--  from accommodation join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID
-- 					join renttype on detailrenttype.rentTypeID = renttype.rentTypeID
--  where price >= 45000000 and price <= 180000000 and rentTypeName in
--  group by accommodation.accommodationID

select * 
from accommodation  join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID 
join detailamenity on accommodation.accommodationID = detailamenity.accommodationID 
join amenity on detailamenity.amenityID = amenity.amenityID 
join renttype on detailrenttype.renttypeID = renttype.renttypeID 
where 1 = 1  AND price >= 45000000 AND price <= 180000000 
				AND (amenityName like'%Gym%' )  
                AND (rentTypeName like'%Yearly%' or rentTypeName like'%Monthly%' )    
group by accommodation.accommodationID;

select * from detailrenttype where accommodationID = 1;

select * from detailamenity where accommodationID = 1;

    select
        * 
    from
        accommodation  
    join
        detailrenttype 
            on accommodation.accommodationID = detailrenttype.accommodationID 
    join
        detailamenity 
            on accommodation.accommodationID = detailamenity.accommodationID 
    join
        amenity 
            on detailamenity.amenityID = amenity.amenityID 
    join
        renttype 
            on detailrenttype.renttypeID = renttype.renttypeID 
    where
        1 = 1  
        AND numberOfRooms = 3 
        AND price >= 45000000 
        AND price <= 180000000 
        AND (
            amenityName like'%Gym%' 
        )  
        AND (
            rentTypeName like'%Yearly%' 
            or rentTypeName like'%Monthly%' 
        )  
    group by
        accommodation.accommodationID;
        
select * 
from accommodation join detailstatus on accommodation.accommodationID = detailstatus.accommodationID
where detailstatus.statusID = 1;

select accommodation.accommodationID, accommodationName, street, ward, district, city, province, size, numberOfRooms, lessorID, direction, accomTypeID 
from accommodation  join detailstatus on accommodation.accommodationID = detailstatus.accommodationID 
where detailstatus.statusID = 1 
ORDER BY RAND() 
LIMIT 3;

select * from status where statusID = 2;
select * from accommodation;
select count(accommodationID) from accommodation where accommodation.accomtypeID = '2';
select accommodation.accommodationID, accommodationName, street, ward, district, city, province, size, numberOfRooms, lessorID, direction, accommodation.accomTypeID 
from accommodation  join accomtype on accommodation.accomTypeID = accomtype.accomTypeID 
where 1 = 1  AND accomType LIKE '%Studio%' AND type like'%Studio%'
group by accommodation.accommodationID;
select * from accommodation;
select accommodation.accommodationID, accommodationName, street, ward, district, city, province, size, numberOfRooms, lessorID, direction, accommodation.accomTypeID 
from accommodation  join accomtype on accommodation.accomTypeID = accomtype.accomTypeID join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID join renttype on detailrenttype.renttypeID = renttype.renttypeID join detailstatus on accommodation.accommodationID = detailstatus.accommodationID 
where detailstatus.statusID = 1  AND numberOfRooms = 2 AND `type` like'%Apartment%' AND (rentTypeName like'%Yearly%' )  
group by accommodation.accommodationID