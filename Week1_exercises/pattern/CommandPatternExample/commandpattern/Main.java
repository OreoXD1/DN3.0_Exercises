// Main.java
public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightsOn = new LightOnCommand(livingRoomLight);
        Command lightsOff = new LightOffCommand(livingRoomLight);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(lightsOn);
        remoteControl.pressButton();

        remoteControl.setCommand(lightsOff);
        remoteControl.pressButton();
    }
}
