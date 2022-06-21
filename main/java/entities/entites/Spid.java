package entities.entites;

import utils.StatusEnum;

import java.util.Date;
public class Spid extends Base{

    private User user;

    private StatusEnum status = StatusEnum.PENDING;

    private String description;

    public Spid() {}

    public Spid(long id, Date createdAt,User user,String description) {
        super(id, createdAt,user.getUsername());
        this.user = user;
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(StatusEnum status) throws Exception {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Spid{" +
                "user=" + user +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
