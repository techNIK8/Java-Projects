public class This {
    private int one;  //Object or Instance Variable
    public This (int X) {
        one = X;      //Local Variable
    }
    public static void main (String[] args) {
        This testThis = new This (79);
        System.out.println (testThis.one);
    }
}

//  Think of it in terms of scope.
//  Everything inside the method has
//  its own little world called local scope ... 
//  everything outside the method has it's world.
//  Now lets say you have a variable outside the method ... 
//  how can the method use that variable when you are inside the method/in local scope.
//  The 'this' keyword switches the scope so that you can use a variable outside the method ...
//  so basically you are telling Java - hey java i dont really want to use the local variable
//  inside the method i want to use the global/instance variable outside the method ...
//  hope that helps