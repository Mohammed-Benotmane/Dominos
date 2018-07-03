package com.example.mohamed.dominos;

public class Tuile {
    private int faceA;
    private int faceB;
    private int image;

    public Tuile(int faceA, int faceB, int image) {
        this.faceA = faceA;
        this.faceB = faceB;
        this.image = image;
    }

    public int getFaceA() {
        return faceA;
    }

    public void setFaceA(int faceA) {
        this.faceA = faceA;
    }

    public int getFaceB() {
        return faceB;
    }

    public void setFaceB(int faceB) {
        this.faceB = faceB;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
