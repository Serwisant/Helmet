package com.drill.gw_helmet;

import java.util.Vector;

public class DisplayFragmentContainer {
    private TextureAtlas atlas;

    private DisplayFragment fallenGuy;

    private Vector<DisplayFragment> guyFragments;

    private Vector<DisplayFragment> hammerFragments;
    private Vector<DisplayFragment> bucketFragments;
    private Vector<DisplayFragment> keyFragments;
    private Vector<DisplayFragment> screwFragments;
    private Vector<DisplayFragment> wrenchFragments;

    private Vector<DisplayFragment> missFragments;

    private Vector<DisplayFragment> pointCounterFragments;
    private Vector<DisplayFragment> pointDigitsFragments;

    public DisplayFragmentContainer() {
        initializeContainers();
    }

    public Vector<DisplayFragment> getGuyFragments() {
        return guyFragments;
    }

    public DisplayFragment getFallenGuyFragment() {
        return fallenGuy;
    }

    public Vector<DisplayFragment> getHammerFragments() {
        return hammerFragments;
    }

    public Vector<DisplayFragment> getBucketFragments() {
        return bucketFragments;
    }

    public Vector<DisplayFragment> getKeyFragments() {
        return keyFragments;
    }

    public Vector<DisplayFragment> getScrewFragments() {
        return screwFragments;
    }

    public Vector<DisplayFragment> getWrenchFragments() {
        return wrenchFragments;
    }

    public Vector<DisplayFragment> getMissFragments() {
        return missFragments;
    }

    public Vector<DisplayFragment> getPointCounterFragments() {
        return pointCounterFragments;
    }

    public Vector<DisplayFragment> getPointDigitsFragments() {
        return pointDigitsFragments;
    }

    public void setTextureAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    public void fillContainers() {

        fallenGuy = new DisplayFragment();
        fallenGuy.setLocation(707, 908);
        fallenGuy.setTexture(atlas.getTexture("fallenGuy"));

        DisplayFragment guy1 = new DisplayFragment();
        guy1.setLocation(214, 688);
        guy1.setTexture(atlas.getTexture("helmetGuy1"));
        guyFragments.add(guy1);

        DisplayFragment guy2 = new DisplayFragment();
        guy2.setLocation(351, 705);
        guy2.setTexture(atlas.getTexture("helmetGuy2"));
        guyFragments.add(guy2);

        DisplayFragment guy3 = new DisplayFragment();
        guy3.setLocation(555, 703);
        guy3.setTexture(atlas.getTexture("helmetGuy3"));
        guyFragments.add(guy3);

        DisplayFragment guy4 = new DisplayFragment();
        guy4.setLocation(763, 698);
        guy4.setTexture(atlas.getTexture("helmetGuy4"));
        guyFragments.add(guy4);

        DisplayFragment guy5 = new DisplayFragment();
        guy5.setLocation(944, 709);
        guy5.setTexture(atlas.getTexture("helmetGuy5"));
        guyFragments.add(guy5);

        DisplayFragment guy6 = new DisplayFragment();
        guy6.setLocation(1139, 707);
        guy6.setTexture(atlas.getTexture("helmetGuy6"));
        guyFragments.add(guy6);

        DisplayFragment guy7 = new DisplayFragment();
        guy7.setLocation(1402, 717);
        guy7.setTexture(atlas.getTexture("helmetGuy7"));
        guyFragments.add(guy7);

        DisplayFragment hammer1 = new DisplayFragment();
        hammer1.setLocation(412, 267);
        hammer1.setTexture(atlas.getTexture("hammer1"));
        hammerFragments.add(hammer1);

        DisplayFragment hammer2 = new DisplayFragment();
        hammer2.setLocation(410, 355);
        hammer2.setTexture(atlas.getTexture("hammer2"));
        hammerFragments.add(hammer2);

        DisplayFragment hammer3 = new DisplayFragment();
        hammer3.setLocation(410, 426);
        hammer3.setTexture(atlas.getTexture("hammer3"));
        hammerFragments.add(hammer3);

        DisplayFragment hammer4 = new DisplayFragment();
        hammer4.setLocation(410, 503);
        hammer4.setTexture(atlas.getTexture("hammer4"));
        hammerFragments.add(hammer4);

        DisplayFragment hammer5 = new DisplayFragment();
        hammer5.setLocation(413, 570);
        hammer5.setTexture(atlas.getTexture("hammer5"));
        hammerFragments.add(hammer5);


        DisplayFragment bucket1 = new DisplayFragment();
        bucket1.setLocation(576, 248);
        bucket1.setTexture(atlas.getTexture("bucket1"));
        bucketFragments.add(bucket1);

        DisplayFragment bucket2 = new DisplayFragment();
        bucket2.setLocation(570, 351);
        bucket2.setTexture(atlas.getTexture("bucket2"));
        bucketFragments.add(bucket2);

        DisplayFragment bucket3 = new DisplayFragment();
        bucket3.setLocation(573, 443);
        bucket3.setTexture(atlas.getTexture("bucket3"));
        bucketFragments.add(bucket3);

        DisplayFragment bucket4 = new DisplayFragment();
        bucket4.setLocation(572, 527);
        bucket4.setTexture(atlas.getTexture("bucket4"));
        bucketFragments.add(bucket4);

        DisplayFragment bucket5 = new DisplayFragment();
        bucket5.setLocation(568, 613);
        bucket5.setTexture(atlas.getTexture("bucket5"));
        bucketFragments.add(bucket5);


        DisplayFragment key1 = new DisplayFragment();
        key1.setLocation(765, 272);
        key1.setTexture(atlas.getTexture("key1"));
        keyFragments.add(key1);

        DisplayFragment key2 = new DisplayFragment();
        key2.setLocation(771, 365);
        key2.setTexture(atlas.getTexture("key2"));
        keyFragments.add(key2);

        DisplayFragment key3 = new DisplayFragment();
        key3.setLocation(765, 439);
        key3.setTexture(atlas.getTexture("key3"));
        keyFragments.add(key3);

        DisplayFragment key4 = new DisplayFragment();
        key4.setLocation(763, 506);
        key4.setTexture(atlas.getTexture("key4"));
        keyFragments.add(key4);

        DisplayFragment key5 = new DisplayFragment();
        key5.setLocation(771, 588);
        key5.setTexture(atlas.getTexture("key5"));
        keyFragments.add(key5);


        DisplayFragment screw1 = new DisplayFragment();
        screw1.setLocation(944,287);
        screw1.setTexture(atlas.getTexture("screw1"));
        screwFragments.add(screw1);

        DisplayFragment screw2 = new DisplayFragment();
        screw2.setLocation(943, 376);
        screw2.setTexture(atlas.getTexture("screw2"));
        screwFragments.add(screw2);

        DisplayFragment screw3 = new DisplayFragment();
        screw3.setLocation(945, 445);
        screw3.setTexture(atlas.getTexture("screw3"));
        screwFragments.add(screw3);

        DisplayFragment screw4 = new DisplayFragment();
        screw4.setLocation(960, 499);
        screw4.setTexture(atlas.getTexture("screw4"));
        screwFragments.add(screw4);

        DisplayFragment screw5 = new DisplayFragment();
        screw5.setLocation(978, 573);
        screw5.setTexture(atlas.getTexture("screw5"));
        screwFragments.add(screw5);


        DisplayFragment wrench1 = new DisplayFragment();
        wrench1.setLocation(1165, 264);
        wrench1.setTexture(atlas.getTexture("wrench1"));
        wrenchFragments.add(wrench1);

        DisplayFragment wrench2 = new DisplayFragment();
        wrench2.setLocation(1189, 342);
        wrench2.setTexture(atlas.getTexture("wrench2"));
        wrenchFragments.add(wrench2);

        DisplayFragment wrench3 = new DisplayFragment();
        wrench3.setLocation(1165, 455);
        wrench3.setTexture(atlas.getTexture("wrench3"));
        wrenchFragments.add(wrench3);

        DisplayFragment wrench4 = new DisplayFragment();
        wrench4.setLocation(1167, 547);
        wrench4.setTexture(atlas.getTexture("wrench4"));
        wrenchFragments.add(wrench4);

        DisplayFragment wrench5 = new DisplayFragment();
        wrench5.setLocation(1168, 622);
        wrench5.setTexture(atlas.getTexture("wrench5"));
        wrenchFragments.add(wrench5);


        DisplayFragment miss1 = new DisplayFragment();
        miss1.setLocation(967, 78);
        missFragments.add(miss1);

        DisplayFragment miss2 = new DisplayFragment();
        miss2.setLocation(1066, 78);
        missFragments.add(miss2);

        DisplayFragment miss3 = new DisplayFragment();
        miss3.setLocation(1167, 78);
        missFragments.add(miss3);

        for(DisplayFragment i : missFragments)
            i.setTexture(atlas.getTexture("miss"));

        DisplayFragment counter1 = new DisplayFragment();
        counter1.setLocation(395, 89);
        pointCounterFragments.add(counter1);

        DisplayFragment counter2 = new DisplayFragment();
        counter2.setLocation(626, 89);
        pointCounterFragments.add(counter2);

        DisplayFragment counter3 = new DisplayFragment();
        counter3.setLocation(776, 89);
        pointCounterFragments.add(counter3);

        for(DisplayFragment i : pointCounterFragments) {
            i.setTexture(atlas.getTexture("digit8"));
            i.turnOff();
        }

        DisplayFragment digit1 = new DisplayFragment();
        digit1.setLocation(395, 89);
        pointDigitsFragments.add(digit1);

        DisplayFragment digit2 = new DisplayFragment();
        digit2.setLocation(626, 89);
        pointDigitsFragments.add(digit2);

        DisplayFragment digit3 = new DisplayFragment();
        digit3.setLocation(776, 89);
        pointDigitsFragments.add(digit3);

        for(DisplayFragment i : pointDigitsFragments) {
            i.setTexture(atlas.getTexture("digit8"));
            i.turnOff();
        }

        DisplayFragment missText = new DisplayFragment();
        missText.setLocation(1018, 196);
        missText.setTexture(atlas.getTexture("missText"));
        missFragments.add(missText);
    }

    private void initializeContainers() {
        fallenGuy = new DisplayFragment();

        guyFragments = new Vector<DisplayFragment>();

        hammerFragments = new Vector<DisplayFragment>();
        bucketFragments = new Vector<DisplayFragment>();
        keyFragments = new Vector<DisplayFragment>();
        screwFragments = new Vector<DisplayFragment>();
        wrenchFragments = new Vector<DisplayFragment>();

        missFragments = new Vector<DisplayFragment>();

        pointCounterFragments = new Vector<DisplayFragment>();

        pointDigitsFragments = new Vector<DisplayFragment>();
    }
}
