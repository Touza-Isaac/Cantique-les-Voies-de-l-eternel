package com.sintel.lesvoiesdeleternel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SommaireActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    TreeMap<String,List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sommaire);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_HOME);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_sommaire);

        expandableListView = findViewById(R.id.expandableList);
        expandableListDetail= DataCantiques.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition==0){
                    switch (childPosition){
                        case 0 :
                            OuvrirCantique(47);
                            return true;
                        case 1 :
                            OuvrirCantique(114);
                            return true;
                        case 2 :
                            OuvrirCantique(2);
                            return true;
                        case 3:
                            OuvrirCantique(8);
                            return true;
                        case 4:
                            OuvrirCantique(11);
                            return true;
                        case 5:
                            OuvrirCantique(82);
                            return true;
                        case 6:
                            OuvrirCantique(60);
                            return true;
                        case 7:
                            OuvrirCantique(75);
                            return true;
                        default:
                            return true;
                    }
                } else if (groupPosition==1){
                    switch (childPosition){
                        case 0 :
                        OuvrirCantique(10);
                        return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==2){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(16);
                            return true;
                        case 1:
                            OuvrirCantique(19);
                            return true;
                        case 2:
                            OuvrirCantique(85);
                            return true;
                        case 3:
                            OuvrirCantique(108);
                            return true;
                        case 4:
                            OuvrirCantique(29);
                            return true;
                        case 5:
                            OuvrirCantique(32);
                            return true;
                        case 6:
                            OuvrirCantique(92);
                            return true;
                        case 7:
                            OuvrirCantique(93);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==3){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(69);
                            return true;
                        case 1:
                            OuvrirCantique(83);
                            return true;
                        case 2:
                            OuvrirCantique(23);
                            return true;
                        case 3:
                            OuvrirCantique(106);
                            return true;
                        case 4:
                            OuvrirCantique(107);
                            return true;
                        case 5:
                            OuvrirCantique(113);
                            return true;
                        case 6:
                            OuvrirCantique(28);
                            return true;
                        case 7:
                            OuvrirCantique(52);
                            return true;
                        case 8:
                            OuvrirCantique(34);
                            return true;
                        case 9:
                            OuvrirCantique(37);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==4){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(54);
                            return true;
                        case 1:
                            OuvrirCantique(66);
                            return true;
                        case 2:
                            OuvrirCantique(76);
                            return true;
                        case 3:
                            OuvrirCantique(78);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==5){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(4);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==6){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(96);
                            return true;
                        case 1:
                            OuvrirCantique(110);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==7){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(25);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==8){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(111);
                            return true;
                        case 1:
                            OuvrirCantique(40);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==9){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(88);
                            return true;
                        case 1:
                            OuvrirCantique(89);
                            return true;
                        case 2:
                            OuvrirCantique(17);
                            return true;
                        case 3:
                            OuvrirCantique(24);
                            return true;
                        case 4:
                            OuvrirCantique(22);
                            return true;
                        case 5:
                            OuvrirCantique(33);
                            return true;
                        case 6:
                            OuvrirCantique(53);
                            return true;
                        case 7:
                            OuvrirCantique(46);
                            return true;
                        case 8:
                            OuvrirCantique(43);
                            return true;
                        case 9:
                            OuvrirCantique(35);
                            return true;
                        case 10:
                            OuvrirCantique(65);
                            return true;
                        case 11:
                            OuvrirCantique(58);
                            return true;
                        case 12:
                            OuvrirCantique(91);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==10){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(26);
                            return true;
                        case 1:
                            OuvrirCantique(49);
                            return true;
                        case 2:
                            OuvrirCantique(59);
                            return true;
                        case 3:
                            OuvrirCantique(45);
                            return true;
                        case 4:
                            OuvrirCantique(71);
                            return true;
                        case 5:
                            OuvrirCantique(36);
                            return true;
                        case 6:
                            OuvrirCantique(105);
                            return true;
                        case 7:
                            OuvrirCantique(74);
                            return true;
                        case 8:
                            OuvrirCantique(38);
                            return true;
                        case 9:
                            OuvrirCantique(42);
                            return true;
                        case 10:
                            OuvrirCantique(64);
                            return true;
                        case 11:
                            OuvrirCantique(101);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==11){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(97);
                            return true;
                        case 1:
                            OuvrirCantique(27);
                            return true;
                        case 2:
                            OuvrirCantique(51);
                            return true;
                        case 3:
                            OuvrirCantique(62);
                            return true;
                        case 4:
                            OuvrirCantique(81);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==12){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(41);
                            return true;
                        case 1:
                            OuvrirCantique(86);
                            return true;
                        case 2:
                            OuvrirCantique(87);
                            return true;
                        case 3:
                            OuvrirCantique(109);
                            return true;
                        case 4:
                            OuvrirCantique(41);
                            return true;
                        default:
                            return true;
                    }

                }
                else if (groupPosition==13){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(1);
                            return true;
                        case 1:
                            OuvrirCantique(5);
                            return true;
                        case 2:
                            OuvrirCantique(20);
                            return true;
                        case 3:
                            OuvrirCantique(63);
                            return true;
                        case 4:
                            OuvrirCantique(84);
                            return true;
                        case 5:
                            OuvrirCantique(95);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==14){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(6);
                            return true;
                        case 1:
                            OuvrirCantique(7);
                            return true;
                        case 2:
                            OuvrirCantique(18);
                            return true;
                        case 3:
                            OuvrirCantique(30);
                            return true;
                        case 4:
                            OuvrirCantique(39);
                            return true;
                        case 5:
                            OuvrirCantique(61);
                            return true;
                        case 6:
                            OuvrirCantique(79);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==15){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(3);
                            return true;
                        case 1:
                            OuvrirCantique(9);
                            return true;
                        case 2:
                            OuvrirCantique(12);
                            return true;
                        case 3:
                            OuvrirCantique(102);
                            return true;
                        case 4:
                            OuvrirCantique(103);
                            return true;
                        case 5:
                            OuvrirCantique(14);
                            return true;
                        case 6:
                            OuvrirCantique(56);
                            return true;
                        case 7:
                            OuvrirCantique(99);
                            return true;
                        case 8:
                            OuvrirCantique(21);
                            return true;
                        case 9:
                            OuvrirCantique(44);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==16){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(13);
                            return true;
                        case 1:
                            OuvrirCantique(70);
                            return true;
                        case 2:
                            OuvrirCantique(80);
                            return true;
                        case 3:
                            OuvrirCantique(112);
                            return true;
                        case 4:
                            OuvrirCantique(50);
                            return true;
                        case 5:
                            OuvrirCantique(48);
                            return true;
                        case 6:
                            OuvrirCantique(72);
                            return true;
                        case 7:
                            OuvrirCantique(73);
                            return true;
                        case 8:
                            OuvrirCantique(68);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==17){
                    switch (childPosition) {
                        case 0:
                            OuvrirCantique(0);
                            return true;
                        case 1:
                            OuvrirCantique(94);
                            return true;
                        case 2:
                            OuvrirCantique(100);
                            return true;
                        case 3:
                            OuvrirCantique(8);
                            return true;
                        case 4:
                            OuvrirCantique(57);
                            return true;
                        case 5:
                            OuvrirCantique(57);
                            return true;
                        case 6:
                            OuvrirCantique(67);
                            return true;
                        case 7:
                            OuvrirCantique(90);
                            return true;
                        case 8:
                            OuvrirCantique(14);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==18){
                    switch (childPosition){
                        case 0:
                            OuvrirCantique(15);
                            return true;
                        case 1:
                            OuvrirCantique(31);
                            return true;
                        default:
                            return true;
                    }
                }
                else if (groupPosition==19){
                    switch (childPosition){
                        case 0:
                            OuvrirCantique(104);
                            return true;
                        case 1:
                            OuvrirCantique(77);
                            return true;
                        default:
                            return true;
                    }
                }
                return false;
            }
        });

    }

    private void OuvrirCantique(int i) {
        Intent intent = new Intent(SommaireActivity.this, CantiqueActivity.class);
        intent.putExtra("position", i);
        startActivity(intent);
    }
}