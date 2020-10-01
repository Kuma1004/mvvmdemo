package com.example.mvvmdemo.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

// SerializedName和API欄位需一致
public class UserDetailData implements Serializable {
    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private int id;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("url")
    private String url;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("followers_url")
    private String followersUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("organizations_url")
    private String organizationsUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("received_events_url")
    private String receivedEventsUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("site_admin")
    private boolean siteAdmin;

    @SerializedName("name")
    private String name;

    @SerializedName("company")
    private String company;

    @SerializedName("blog")
    private String blog;

    @SerializedName("location")
    private String location;

    @SerializedName("email")
    private String email;

    @SerializedName("hireable")
    private String hireable;

    @SerializedName("bio")
    private String bio;

    @SerializedName("public_repos")
    private int publicRepos;

    @SerializedName("public_gists")
    private int publicGists;

    @SerializedName("followers")
    private int followers;

    @SerializedName("following")
    private int following;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setNodeId(String nodeId){
        this.nodeId = nodeId;
    }
    public String getNodeId(){
        return nodeId;
    }

    public void setAvatarUrl(String avatarUrl){
        this.avatarUrl = avatarUrl;
    }
    public String getAvatarUrl(){
        return avatarUrl;
    }

    public void setGravatarId(String gravatarId){
        this.gravatarId = gravatarId;
    }
    public String getGravatarId(){
        return gravatarId;
    }

    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return url;
    }

    public void setHtmlUrl(String htmlUrl){
        this.htmlUrl = htmlUrl;
    }
    public String getHtmlUrl(){
        return htmlUrl;
    }

    public void setFollowersUrl(String followersUrl){
        this.followersUrl = followersUrl;
    }
    public String getFollowersUrl(){
        return followersUrl;
    }

    public void setFollowingUrl(String followingUrl){
        this.followingUrl = followingUrl;
    }
    public String getFollowingUrl(){
        return followingUrl;
    }

    public void setGistsUrl(String gistsUrl){
        this.gistsUrl = gistsUrl;
    }
    public String getGistsUrl(){
        return gistsUrl;
    }

    public void setStarredUrl(String starredUrl){
        this.starredUrl = starredUrl;
    }
    public String getStarredUrl(){
        return starredUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl){ this.subscriptionsUrl = subscriptionsUrl; }
    public String getSubscriptionsUrl(){
        return subscriptionsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl){ this.organizationsUrl = organizationsUrl; }
    public String getOrganizationsUrl(){
        return organizationsUrl;
    }

    public void setReposUrl(String reposUrl){
        this.reposUrl = reposUrl;
    }
    public String getReposUrl(){
        return reposUrl;
    }

    public void setEventsUrl(String eventsUrl){
        this.eventsUrl = eventsUrl;
    }
    public String getEventsUrl(){
        return eventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl){ this.receivedEventsUrl = receivedEventsUrl; }
    public String getReceivedEventsUrl(){
        return receivedEventsUrl;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public void setSiteAdmin(boolean siteAdmin){
        this.siteAdmin = siteAdmin;
    }
    public boolean isSiteAdmin(){
        return siteAdmin;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setCompany(String company){
        this.company = company;
    }
    public String getCompany(){
        return company;
    }

    public void setBlog(String blog){
        this.blog = blog;
    }
    public String getBlog(){
        return blog;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setHireable(String hireable){
        this.hireable = hireable;
    }
    public String getHireable(){
        return hireable;
    }

    public void setBio(String bio){
        this.bio = bio;
    }
    public String getBio(){
        return bio;
    }

    public void setPublicRepos(int publicRepos){
        this.publicRepos = publicRepos;
    }
    public int getPublicRepos(){
        return publicRepos;
    }

    public void setPublicGists(int publicGists){
        this.publicGists = publicGists;
    }
    public int getPublicGists(){
        return publicGists;
    }

    public void setFollowers(int followers){
        this.followers = followers;
    }
    public int getFollowers(){
        return followers;
    }

    public void setFollowing(int following){
        this.following = following;
    }
    public int getFollowing(){
        return following;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    public String getCreatedAt(){
        return createdAt;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAt(){
        return updatedAt;
    }
}
