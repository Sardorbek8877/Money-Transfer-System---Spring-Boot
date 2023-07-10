package uz.bek.moneytransferapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String firstName;



    

}


/*
Pul o'tkazmalarini amalga oshiruvchi dastur tuzing.
User sistemaga authentication orqali kirib, o'ziga tegishli CARD orqali
boshqa CARD ga pul transfer qilish jarayonini amalga oshirsin.
Transfer jarayonida CARD da o'tkazilayotgan va transfer uchun kommisiya
miqdoridagi mablag' yetarli ekanligi va CARD shu user ga tegishli ekanligi tekshirilsin.
Kartadagi kirimlarni va chiqimlarni alohida yozib boring.
Foydalanuvchi o'ziga tegishli card tarixini (output, income) ko'rsatuvchi method yozing
 */
