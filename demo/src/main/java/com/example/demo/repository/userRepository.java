package com.example.demo.repository;

// import java.time.LocalDate;

// 必要なツールをインポートしています
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// Userクラスを使うためにインポートしています
import com.example.demo.model.user;
// import java.util.List;


//Userエンティティに対してデータベース操作を行うためのリポジトリr
public interface userRepository extends JpaRepository<user, Long> {
    // ユーザー名でユーザーを探すメソッド。ユーザー名をパラメータとして渡すと、そのユーザー名を持つユーザーをデータベースから探して返します。
	user findByUsername(String username);

	// user findById(Integer id);
    // Optional<user> = findById(Integer id);

    // @Query("SELECT ,FROM users ")
    // public user findById(Integer userId); 
    

    
    // @Query(value = "INSERT INTO sample VALUES(:id, :name, :password)")
	// void InsertData(@Param("id") Integer id, 
	// 		       @Param("name") String name,
	// 		       @Param("password") String password ,
	// 		       @Param("birthday") LocalDate birthday
    // );
     
    // public user findBirthday(String token);

     // @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    // public user findByEmail(String email); 
     
    // public user findByResetPasswordToken(String token);
}
