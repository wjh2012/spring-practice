package practice.jpa.user;

import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import practice.jpa.BaseEntity;

@Entity
@Getter
class UserEntity extends BaseEntity {

    private String name;
}