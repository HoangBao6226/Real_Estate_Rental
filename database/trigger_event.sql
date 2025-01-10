use real_estate;
SET GLOBAL event_scheduler = ON;
SHOW EVENTS;
-- DROP EVENT IF EXISTS update_status_periodically;

CREATE EVENT update_invoiceStatus_periodically
ON SCHEDULE EVERY 1 MINUTE
DO
    -- Cập nhật trạng thái trong bảng invoice
    UPDATE invoice
    SET status = 'Completed'
    WHERE (endDate < NOW()) AND (status != 'Completed');

ALTER EVENT update_accomStatus_periodically
ON SCHEDULE EVERY 1 MINUTE
DO
    -- Cập nhật trạng thái trong bảng accommodation
    UPDATE accommodation
    SET status = 'Unavailable'
    WHERE accommodation.accommodationID IN ( SELECT accommodationID FROM invoice WHERE status = 'Completed')
			AND status = 'Occupied';



    
