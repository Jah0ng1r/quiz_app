package uz.fbtuit.quiz_app_maven.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "userhpandatars")
@Entity
public class UserHpAndStars implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private static final String sequence = "user_Hp_Starts_sequence";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hp")
    private Integer hp;
    @Column(name = "Stars")
    private Integer stars;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public UserHpAndStars() {
    }

    public UserHpAndStars(Integer hp, Integer stars, User user) {
        this.hp = hp;
        this.stars = stars;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}