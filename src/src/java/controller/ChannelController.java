/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.ChannelDAO;
import entity.Channel;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import util.UserControl;


@Named(value = "channelController")
@SessionScoped
public class ChannelController extends UserControl implements Serializable {
    
    
    private List<Channel> channels;
    private ChannelDAO channelDAO;
    private Channel channel; 
  
    public ChannelController() throws IOException {
        this.isAdmin();
    }
    
    
    
    public Channel getChannel(){
        if(channel == null){
            channel = new Channel();
        }
        return this.channel;
    }
    
    public void setChannel(Channel channel){
        this.channel = channel;
    }
    
    public void createChannel(){
        channelDAO.create(this.channel);
        channel = new Channel();
    }
    
    public void deleteChannel(Channel channel){
        channelDAO.delete(channel);
        
    }
    
    public void updateChannel(){
        channelDAO.update(this.channel);
        channel = new Channel();
    }
    
    public List<Channel> getChannels() {
        channelDAO = new ChannelDAO();
        return channelDAO.list();
    }
    
}
