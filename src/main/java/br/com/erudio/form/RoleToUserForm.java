package br.com.erudio.form;

public class RoleToUserForm {
    
    private String userName;
    private String roleName;
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        RoleToUserForm other = (RoleToUserForm) obj;
        if (roleName == null) {
            if (other.roleName != null) return false;
        } else if (!roleName.equals(other.roleName)) return false;
        if (userName == null) {
            if (other.userName != null) return false;
        } else if (!userName.equals(other.userName)) return false;
        return true;
    }
}
