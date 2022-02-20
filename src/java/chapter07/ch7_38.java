package java.chapter07;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ch7_38 {
    public static void main(String[] args) {
        Button b=new Button("Start");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ACtionEvent occured!!");
            }
        });
    }
}
