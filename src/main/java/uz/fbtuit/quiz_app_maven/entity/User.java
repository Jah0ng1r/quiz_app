package uz.fbtuit.quiz_app_maven.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "QuizUser")
@Table
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private static final String sequence = "quiz_user_sequence";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "nickName")
    private String nickName;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;


    @OneToOne(mappedBy = "user")
    private UserHpAndStars userHpAndStars;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
    private Set<QuestionTable> questionTable;

    public User() {
    }

    public User(String phoneNumber, String nickName, String name, String lastName, UserHpAndStars userHpAndStars, Set<QuestionTable> questionTable) {
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.name = name;
        this.lastName = lastName;
        this.userHpAndStars = userHpAndStars;
        this.questionTable = questionTable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserHpAndStars getUserHpAndStars() {
        return userHpAndStars;
    }

    public void setUserHpAndStars(UserHpAndStars userHpAndStars) {
        this.userHpAndStars = userHpAndStars;
    }

    public Set<QuestionTable> getQuestionTable() {
        return questionTable;
    }

    public void setQuestionTable(Set<QuestionTable> questionTable) {
        this.questionTable = questionTable;
    }
}
