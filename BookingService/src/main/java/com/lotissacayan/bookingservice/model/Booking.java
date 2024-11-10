package com.lotissacayan.bookingservice.model;


import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    @Id
    private String bookingId;
    private String userId;
    private String roomId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String purpose;


    public Booking(){}


    public Booking(String bookingId, String userID, String roomId, LocalDateTime startDate, LocalDateTime endDate, String purpose){
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.purpose = purpose;
    }


    public String getBookingId(){
        return bookingId;
    }


    public void setBookingId(String bookingId){
        this.bookingId= bookingId;
    }

    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getRoomId(){
        return roomId;
    }
    public void setRoomId(String roomId){
        this.roomId = roomId;
    }
    public LocalDateTime getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate){
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate(){
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate){
        this.endDate = endDate;
    }
    public String getPurpose(){
        return purpose;
    }
    public void setPurpose(String purpose){
        this.purpose = purpose;
    }

    @Override
    public String toString(){
        return "Booking{" +
                "bookingId='" +bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ",roomId='" + roomId + '\'' +
                ",startDate='" + startDate +
                ",endDate='" + endDate +
                ",purpose='" + purpose +'\'' +
                '}';
    }
}

