package com.drill.gw_helmet;

import java.util.Vector;

public class DisplayFragmentContainer {
    private TextureAtlasWrapper atlas;

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

    public void setSpriteAtlas(TextureAtlasWrapper atlas) {
        this.atlas = atlas;
    }

    public void fillContainers() {
        prepareGuyFragments();
        prepareHammerFragments();
        prepareBucketFragments();
        prepareKeyFragments();
        prepareScrewFragments();
        prepareWrenchFragments();
        prepareGUIFragments();
    }

    private void prepareGuyFragments() {
        fallenGuy = new DisplayFragment();
        fallenGuy.setLocation(655, 848);
        fallenGuy.setSprite(atlas.getSprite("HelmetGuy/FallenGuy"));

        DisplayFragment guy1 = new DisplayFragment();
        guy1.setLocation(174, 658);
        guy1.setSprite(atlas.getSprite("HelmetGuy/HelmetGuy1"));
        guyFragments.add(guy1);

        DisplayFragment guy2 = new DisplayFragment();
        guy2.setLocation(306, 673);
        guy2.setSprite(atlas.getSprite("HelmetGuy/HelmetGuy2"));
        guyFragments.add(guy2);

        DisplayFragment guy3 = new DisplayFragment();
        guy3.setLocation(508, 673);
        guy3.setSprite(atlas.getSprite("HelmetGuy/HelmetGuy3"));
        guyFragments.add(guy3);

        DisplayFragment guy4 = new DisplayFragment();
        guy4.setLocation(710, 667);
        guy4.setSprite(atlas.getSprite("HelmetGuy/HelmetGuy4"));
        guyFragments.add(guy4);

        DisplayFragment guy5 = new DisplayFragment();
        guy5.setLocation(890, 678);
        guy5.setSprite(atlas.getSprite("HelmetGuy/HelmetGuy5"));
        guyFragments.add(guy5);

        DisplayFragment guy6 = new DisplayFragment();
        guy6.setLocation(1080, 677);
        guy6.setSprite(atlas.getSprite("HelmetGuy/HelmetGuy6"));
        guyFragments.add(guy6);

        DisplayFragment guy7 = new DisplayFragment();
        guy7.setLocation(1338, 686);
        guy7.setSprite(atlas.getSprite("HelmetGuy/HelmetGuy7"));
        guyFragments.add(guy7);
    }

    private void prepareHammerFragments() {
        DisplayFragment hammer1 = new DisplayFragment();
        hammer1.setLocation(366, 244);
        hammer1.setSprite(atlas.getSprite("Hammer/Hammer1"));
        hammerFragments.add(hammer1);

        DisplayFragment hammer2 = new DisplayFragment();
        hammer2.setLocation(364, 329);
        hammer2.setSprite(atlas.getSprite("Hammer/Hammer2"));
        hammerFragments.add(hammer2);

        DisplayFragment hammer3 = new DisplayFragment();
        hammer3.setLocation(365, 402);
        hammer3.setSprite(atlas.getSprite("Hammer/Hammer3"));
        hammerFragments.add(hammer3);

        DisplayFragment hammer4 = new DisplayFragment();
        hammer4.setLocation(362, 475);
        hammer4.setSprite(atlas.getSprite("Hammer/Hammer4"));
        hammerFragments.add(hammer4);

        DisplayFragment hammer5 = new DisplayFragment();
        hammer5.setLocation(368, 541);
        hammer5.setSprite(atlas.getSprite("Hammer/Hammer5"));
        hammerFragments.add(hammer5);
    }

    private void prepareBucketFragments() {
        DisplayFragment bucket1 = new DisplayFragment();
        bucket1.setLocation(528, 227);
        bucket1.setSprite(atlas.getSprite("Bucket/Bucket1"));
        bucketFragments.add(bucket1);

        DisplayFragment bucket2 = new DisplayFragment();
        bucket2.setLocation(521, 325);
        bucket2.setSprite(atlas.getSprite("Bucket/Bucket2"));
        bucketFragments.add(bucket2);

        DisplayFragment bucket3 = new DisplayFragment();
        bucket3.setLocation(524, 417);
        bucket3.setSprite(atlas.getSprite("Bucket/Bucket3"));
        bucketFragments.add(bucket3);

        DisplayFragment bucket4 = new DisplayFragment();
        bucket4.setLocation(524, 498);
        bucket4.setSprite(atlas.getSprite("Bucket/Bucket4"));
        bucketFragments.add(bucket4);

        DisplayFragment bucket5 = new DisplayFragment();
        bucket5.setLocation(519, 582);
        bucket5.setSprite(atlas.getSprite("Bucket/Bucket5"));
        bucketFragments.add(bucket5);

    }

    private void prepareKeyFragments() {
        DisplayFragment key1 = new DisplayFragment();
        key1.setLocation(713, 249);
        key1.setSprite(atlas.getSprite("Key/Key1"));
        keyFragments.add(key1);

        DisplayFragment key2 = new DisplayFragment();
        key2.setLocation(718, 340);
        key2.setSprite(atlas.getSprite("Key/Key2"));
        keyFragments.add(key2);

        DisplayFragment key3 = new DisplayFragment();
        key3.setLocation(712, 412);
        key3.setSprite(atlas.getSprite("Key/Key3"));
        keyFragments.add(key3);

        DisplayFragment key4 = new DisplayFragment();
        key4.setLocation(712, 478);
        key4.setSprite(atlas.getSprite("Key/Key4"));
        keyFragments.add(key4);

        DisplayFragment key5 = new DisplayFragment();
        key5.setLocation(715, 558);
        key5.setSprite(atlas.getSprite("Key/Key5"));
        keyFragments.add(key5);
    }

    private void prepareScrewFragments() {
        DisplayFragment screw1 = new DisplayFragment();
        screw1.setLocation(889, 264);
        screw1.setSprite(atlas.getSprite("Screw/Screw1"));
        screwFragments.add(screw1);

        DisplayFragment screw2 = new DisplayFragment();
        screw2.setLocation(887, 352);
        screw2.setSprite(atlas.getSprite("Screw/Screw2"));
        screwFragments.add(screw2);

        DisplayFragment screw3 = new DisplayFragment();
        screw3.setLocation(888, 420);
        screw3.setSprite(atlas.getSprite("Screw/Screw3"));
        screwFragments.add(screw3);

        DisplayFragment screw4 = new DisplayFragment();
        screw4.setLocation(903, 472);
        screw4.setSprite(atlas.getSprite("Screw/Screw4"));
        screwFragments.add(screw4);

        DisplayFragment screw5 = new DisplayFragment();
        screw5.setLocation(922, 546);
        screw5.setSprite(atlas.getSprite("Screw/Screw5"));
        screwFragments.add(screw5);
    }

    private void prepareWrenchFragments() {
        DisplayFragment wrench1 = new DisplayFragment();
        wrench1.setLocation(1104, 242);
        wrench1.setSprite(atlas.getSprite("Wrench/Wrench1"));
        wrenchFragments.add(wrench1);

        DisplayFragment wrench2 = new DisplayFragment();
        wrench2.setLocation(1129, 316);
        wrench2.setSprite(atlas.getSprite("Wrench/Wrench2"));
        wrenchFragments.add(wrench2);

        DisplayFragment wrench3 = new DisplayFragment();
        wrench3.setLocation(1105, 427);
        wrench3.setSprite(atlas.getSprite("Wrench/Wrench3"));
        wrenchFragments.add(wrench3);

        DisplayFragment wrench4 = new DisplayFragment();
        wrench4.setLocation(1108, 518);
        wrench4.setSprite(atlas.getSprite("Wrench/Wrench4"));
        wrenchFragments.add(wrench4);

        DisplayFragment wrench5 = new DisplayFragment();
        wrench5.setLocation(1109, 592);
        wrench5.setSprite(atlas.getSprite("Wrench/Wrench5"));
        wrenchFragments.add(wrench5);
    }

    private void prepareGUIFragments() {
        DisplayFragment miss1 = new DisplayFragment();
        miss1.setLocation(882, 58);
        missFragments.add(miss1);

        DisplayFragment miss2 = new DisplayFragment();
        miss2.setLocation(978, 58);
        missFragments.add(miss2);

        DisplayFragment miss3 = new DisplayFragment();
        miss3.setLocation(1078, 58);
        missFragments.add(miss3);

        for(DisplayFragment i : missFragments)
            i.setSprite(atlas.getSprite("GUI/MissIcon"));

        DisplayFragment counter1 = new DisplayFragment();
        counter1.setLocation(337, 66);
        pointCounterFragments.add(counter1);

        DisplayFragment counter2 = new DisplayFragment();
        counter2.setLocation(559, 66);
        pointCounterFragments.add(counter2);

        DisplayFragment counter3 = new DisplayFragment();
        counter3.setLocation(700, 66);
        pointCounterFragments.add(counter3);

        for(DisplayFragment i : pointCounterFragments) {
            i.setSprite(atlas.getSprite("GUI/Digit8"));
            i.turnOff();
        }


        DisplayFragment digit1 = new DisplayFragment();
        digit1.setLocation(337, 66);
        pointDigitsFragments.add(digit1);

        DisplayFragment digit2 = new DisplayFragment();
        digit2.setLocation(559, 66);
        pointDigitsFragments.add(digit2);

        DisplayFragment digit3 = new DisplayFragment();
        digit3.setLocation(700, 66);
        pointDigitsFragments.add(digit3);

        for(DisplayFragment i : pointDigitsFragments) {
            i.setSprite(atlas.getSprite("GUI/Digit8"));
            i.turnOff();
        }

        DisplayFragment missText = new DisplayFragment();
        missText.setLocation(933, 168);
        missText.setSprite(atlas.getSprite("GUI/MissText"));
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
