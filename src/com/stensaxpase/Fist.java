package com.stensaxpase;

public abstract class Fist {
     //olika typer av hand
     enum Types {
          ROCK,
          PAPER,
          SCISSORS
     }

     Types selected;

     public Fist(Types selected) {
          this.selected = selected;
     }

     //hämta den satta typen
     public Types getSelected() {
          return selected;
     }

     public void setSelected(Types selected) {
          this.selected = selected;
     }
}
