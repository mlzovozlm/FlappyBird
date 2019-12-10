/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameWork;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author phamn
 */
public class Animation {
    
    private long beginTime = 0;
    
    private long measure = 20;
    
    private imageFrame[] frames;
    private int NumOfFrame = 0;
    private int CurrentFrame = 0;
    
    public Animation(long measure){
        this.measure = measure;
    }
    
    public void Update_Me(long deltaTime){
        if(NumOfFrame>0){
            if(deltaTime - beginTime > measure){
                CurrentFrame++;
                if(CurrentFrame>=NumOfFrame) 
                    CurrentFrame = 0;
                beginTime = deltaTime;
            }
        }
    }
    public void AddFrame(imageFrame sprite){
        imageFrame[] bufferSprites = frames;
        frames = new imageFrame[NumOfFrame+1];
        for(int i = 0;i<NumOfFrame;i++) frames[i] = bufferSprites[i];
        frames[NumOfFrame] = sprite;
        NumOfFrame++;
    }
    
    public void PaintAnims(int x, int y, BufferedImage image, Graphics2D g2, int anchor, float rotation){
        frames[CurrentFrame].Paint(x, y, image, g2, anchor, rotation);
    }
}
