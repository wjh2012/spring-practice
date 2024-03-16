package practice.jpa.mapping.oneway.OneToMany;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Oneway_Team_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    @Builder.Default
    private List<Oneway_Member_Slave> onewayMemberSlaves = new ArrayList<>();

}
