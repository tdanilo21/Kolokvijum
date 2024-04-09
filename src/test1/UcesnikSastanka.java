package test1;

public class UcesnikSastanka {
    private String username;

    public UcesnikSastanka(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString(){
        return "UcesnikSastanka { username = '" + username + "' }";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        UcesnikSastanka ucesnik = (UcesnikSastanka)o;
        return this.username.equals(ucesnik.username);
    }
}
