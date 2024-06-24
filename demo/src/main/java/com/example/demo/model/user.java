package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//ユーザーのデータを表現するためのクラス。
@Entity
@Table(name = "users", schema = "fusion_db")

public class user {
    @Id  // これが各ユーザを一意に識別するためのIDとなります
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDは自動的に増加します
    @Column(name = "id")  // データベースに合わせてカラム名を修正
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)  // "username" カラム。各ユーザーのユーザー名を表します。同じ名前のユーザーは存在できません
    private String username;

    @Column(name = "email", nullable = false, unique = true)  // "email" カラム。ユーザーのメールアドレスを表します。同じメールアドレスのユーザーは存在できません
    private String email;

    // @Size(min = 8, message = "8文字以上の記入をお願いします")
    @Column(name = "password", nullable = false)  // "password" カラム。ユーザーのパスワードを表します
    private String password;

    @Column(name = "birthday", nullable = false) //誕生日
    private LocalDate birthday;

    // 以下は各値を取得するためのメソッド（ゲッター）です。
    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    // public String getResetPasswordToken() {
    //     return this.resetPasswordToken;
    // }

     public LocalDate getBirthday() {
         return this.birthday;
     }

    // 以下は各値を設定するためのメソッド（セッター）です。
    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }   

    public void setPassword(String password) {
        this.password = password;
    }

    // public void setResetPasswordToken(String resetPasswordToken) {
    //     this.resetPasswordToken = resetPasswordToken;
    // }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
