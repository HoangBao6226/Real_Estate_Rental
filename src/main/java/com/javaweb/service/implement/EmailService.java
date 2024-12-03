package com.javaweb.service.implement;

import com.javaweb.entity.ReservationEntity;
import com.javaweb.repository.itface.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ReservationRepository reservationRepository;

    public void sendThankYouEmail(String to, int id) {

        ReservationEntity re = reservationRepository.findById(id).get();

        String subject = "Cảm ơn quý khách đã đặt lịch xem nhà!";

        // Nội dung email
        String body = "Kính gửi " + re.getLesseeID().getLastName() + " " + re.getLesseeID().getFirstName() + ",\n\n"
                + "Cảm ơn quý khách đã tin tưởng và sử dụng dịch vụ cho thuê bất động sản của chúng tôi!\n\n"
                + "Lịch hẹn xem nhà của quý khách đã được xác nhận như sau:\n"
                + "- Tên nhà: " + re.getAccommodationID().getAccommodationName() + "\n"
                + "- Địa chỉ: " + re.getAccommodationID().getStreet() + ", " + re.getAccommodationID().getWard() + ", " + re.getAccommodationID().getDistrict() + ", " + re.getAccommodationID().getCity()+ "\n"
                + "- Thời gian: " + re.getViewDate() + " " + re.getViewTime() + "\n"
                + "- Người phụ trách: " + "contactPerson" + " - " + "contactPhone" + "\n\n"
                + "Nếu quý khách cần thêm thông tin về bất động sản hoặc có bất kỳ thay đổi nào về lịch hẹn, xin vui lòng liên hệ với chúng tôi qua email này hoặc số điện thoại hỗ trợ.\n\n"
                + "Chúng tôi cam kết mang đến sự hài lòng và trải nghiệm tốt nhất cho quý khách. Một lần nữa, xin cảm ơn quý khách đã lựa chọn dịch vụ của chúng tôi!\n\n"
                + "Trân trọng,\n"
                + "[RER]\n"
                + "[Email liên hệ] | [Số điện thoại liên hệ]\n"
                + "[Website công ty]";

        // Tạo email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("your-email@gmail.com");

        // Gửi email
        mailSender.send(message);
    }
}

