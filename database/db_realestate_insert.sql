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
    ('nguyenvananh', 'password123', 1, 1, null),
    ('tranthimai', 'password345', 2, 2, null),
    ('lengochung', 'password456', 2, 3, null),

    ('hoangngoclinh', 'password678', 3, null, 1),
    ('phamminhduc', 'password789', 3, null, 2),
    ('buithithu', 'password890', 3, null, 3),
    ('tieuanhtuan', 'password901', 3, null, 4),
    ('duongngocchau', 'password012', 3, null, 5),
    ('dovankien', 'password123', 3, null, 6),
    ('vuhyphuong', 'password234', 3, null, 7);
    
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

INSERT INTO Accommodation (accommodationName, street, ward, district, city, province, direction, size, numberOfRooms, lessorID, accomTypeID)
VALUES
	('The Elysian Apartment', '46 Nguyễn Huệ', 'Bến Nghé', 'Quận 1', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Nam', 75.00, 2, 1, 1),
	('Azure Skies Studio', '123 Thảo Điền', 'An Thú', 'Quận 2', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Đông', 40.00, 1, 3, 2),
	('The Haven Villa', '225 Nguyễn Văn Linh', 'Tân Phú', 'Quận 7', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Nam', 250.00, 5, 3, 3),
	('The Grandiose House', '79 Nguyễn Thị Minh Khai', '6', 'Quận 3', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Bắc', 120.00, 3, 3, 4),
	('The Pinnacle Room', '88 Phạm Ngọc Thạch', 'Phú Nhuận', 'Quận 5', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Tây', 30.00, 1, 5, 5),
	
    ('The Willow Creek Apartment', 'Phố Hàng Trọng', 'Hàng Trọng', 'Hoàn Kiếm', 'Hà Nội', 'Hà Nội', 'Bắc', 60.00, 2, 2, 1),
	('Ocean Breeze Studio', 'Hồ Trúc Bạch', 'Trúc Bạch', 'Tây Hồ', 'Hà Nội', 'Hà Nội', 'Tây', 45.00, 1, 6, 2),
	('The Forest Retreat Villa', '1162 Nguyễn Du', 'Đống Đa', 'Đống Đa', 'Hà Nội', 'Hà Nội', 'Nam', 180.00, 4, 4, 3),
	('Mountain View House', '80 Võ Chí Công', 'Cửa Lò', 'Bắc Từ Liêm', 'Hà Nội', 'Hà Nội', 'Đông', 100.00, 3, 4, 4),
	('The Sunnyside Room', '638 Trường Chinh', 'Thanh Xuân Trung', 'Thanh Xuân', 'Hà Nội', 'Hà Nội', 'Nam', 25.00, 1, 7, 5),
	
    ('The Wanderlust Apartment', '980 Võ Nguyên Giáp', 'Khai Hương', 'Ngũ Hành Sơn', 'Đà Nẵng', 'Đà Nẵng', 'Đông', 80.00, 2, 7, 1),
	('The Nomad Studio', '76 Trường Sa', 'An Hải Bắc', 'Sơn Trà', 'Đà Nẵng', 'Đà Nẵng', 'Nam', 35.00, 1, 5, 2),
	('The Eccentric Villa', '90 Hoàng Hoa Thắm', 'Thanh Khê Tây', 'Thanh Khê', 'Đà Nẵng', 'Đà Nẵng', 'Bắc', 200.00, 4, 4, 3),
	('The Bohemian House', '764 Nguyễn Văn Linh', 'Liên Chiều', 'Liên Chiều', 'Đà Nẵng', 'Đà Nẵng', 'Tây', 150.00, 3, 1, 4),
	('The Enigma Room', '912 Nguyễn Văn Linh', 'Cẩm Lệ', 'Cẩm Lệ', 'Đà Nẵng', 'Đà Nẵng', 'Đông', 20.00, 1, 3, 5);

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

INSERT INTO Status (status, description) 
VALUES
	('Available', 'Sẵn sàng cho thuê'),
    ('Unavailable', 'Không sẵn sàng cho thuê'),
	('Occupied', 'Đã được thuê');
    
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

INSERT INTO DetailStatus (accommodationID, statusID, startDate, endDate, reason) 
VALUES
	(1, 2, NULL, NULL, 'Không sẵn sàng cho thuê'),
	(2, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
	(3, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
	(4, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
    (5, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
	(6, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
    (7, 2, NULL, NULL, 'Không sẵn sàng cho thuê'),
	(8, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
    (9, 2, NULL, NULL, 'Không sẵn sàng cho thuê'),
	(10, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
    (11, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
	(12, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
    (13, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
	(14, 1, NULL, NULL, 'Sẵn sàng cho thuê'),
    (15, 1, NULL, NULL, 'Sẵn sàng cho thuê');

use real_estate;

select * from Accommodation;
select * from AccomType;
select * from Account;
select * from Advantage;
select * from Amenity;
select * from DetailAmenity;
select * from DetailRentType order by accommodationID ASC;
select * from DetailStatus;
select * from Status;
select * from Invoice;
select * from Lessee;
select * from Payment;
select * from RentType;
select * from Reservation;
select * from Role;

select * from user;

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