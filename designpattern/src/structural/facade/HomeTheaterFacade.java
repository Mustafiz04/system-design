package structural.facade;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.lights = lights;
    }

    public void turnOn () {
        this.dvdPlayer.turnOn();
        this.amplifier.turnOn();
        this.lights.turnOn();
    }

    public void turnOff() {
        this.dvdPlayer.turnOff();
        this.amplifier.turnOff();
        this.lights.turnOff();
    }
}
