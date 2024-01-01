import behavioral.chainofresponsibility.Director;
import behavioral.chainofresponsibility.Manager;
import behavioral.chainofresponsibility.PurchaseRequest;
import behavioral.chainofresponsibility.VicePresident;
import behavioral.command.RemoteControl;
import behavioral.command.TV;
import behavioral.command.TvOffCommand;
import behavioral.command.TvOnCommand;
import behavioral.mediatior.AirTrafficControl;
import behavioral.mediatior.AirTrafficControlCenter;
import behavioral.mediatior.AirbusA380;
import behavioral.mediatior.Boeing747;
import behavioral.momento.History;
import behavioral.momento.TextEditor;
import behavioral.momento.TextEditorMemento;
import behavioral.observer.*;
import behavioral.state.VendingMachine;
import behavioral.strategy.CreditCardPayment;
import behavioral.strategy.PayPalPayment;
import behavioral.strategy.PaymentStrategy;
import behavioral.strategy.ShoppingCart;
import behavioral.template.DocumentConverter;
import behavioral.template.PdfDocumentConverter;
import behavioral.template.WordDocumentConverter;
import creational.abstractfactory.CatPetFactory;
import creational.abstractfactory.DogPetFactory;
import creational.abstractfactory.Food;
import creational.abstractfactory.PetFactory;
import creational.builder.GamingLaptop;
import creational.builder.Laptop;
import creational.builder.SimpleLaptop;
import creational.factorymethod.Animals;
import creational.factorymethod.AnimalsFactory;
import creational.factorymethod.CatFactory;
import creational.factorymethod.DogFactory;
import creational.prototype.Computer;
import creational.simplefactory.Animal;
import creational.simplefactory.AnimalFactory;
import creational.singleton.President;
import structural.adapter.NewSystemClient;
import structural.adapter.NewSystemInterface;
import structural.adapter.OldSystem;
import structural.adapter.OldSystemAdapter;
import structural.bridge.*;
import structural.composite.Directory;
import structural.composite.File;
import structural.composite.FileSystem;
import structural.decorator.ChickenPizza;
import structural.decorator.ExtraCheese;
import structural.decorator.Pizza;
import structural.decorator.PlainPizza;
import structural.facade.Amplifier;
import structural.facade.DVDPlayer;
import structural.facade.HomeTheaterFacade;
import structural.facade.Lights;

import javax.print.Doc;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Singleton
//        President president = President.getInstance();
//        president.setName("John Doe");
//        president.setPartyName("Unity Party");
//        System.out.println(president.getName());
//        president.setName("John");
//        president.setPartyName("Part Party");
//
//        System.out.println(president.getName());

        System.out.println("-------------------------------------");
//        Simple Factory
//        Animal dog = AnimalFactory.createAnimal("DOG");
//        dog.makeSound();
//        Animal cat = AnimalFactory.createAnimal("CAT");
//        cat.makeSound();

        System.out.println("-------------------------------------");

//        Factory Method
//        AnimalsFactory dogFactory = new DogFactory();
//        AnimalsFactory catFactory = new CatFactory();
//
//        Animals dog = dogFactory.createAnimal();
//        Animals cat = catFactory.createAnimal();
//
//        dog.makeSound();
//        cat.makeSound();

        System.out.println("-------------------------------------");

//        AbstractFactory
//        PetFactory dogPet = new DogPetFactory();
//        Animal dog = dogPet.createAnimal();
//        Food dogFood = dogPet.createFood();
//        dog.makeSound();
//        dogFood.consume();
//
//        PetFactory catPet = new CatPetFactory();
//        Animal cat = catPet.createAnimal();
//        Food catFood = catPet.createFood();
//        cat.makeSound();
//        catFood.consume();

        System.out.println("-------------------------------------");

//        Builder Pattern
        Laptop gamingLaptop = new GamingLaptop.GamingLaptopBuilder()
                .setProcessor("RTX")
                .setRAM("8 GB")
                .setStorage("1 TB")
                .setGraphicCard("16 GB")
                .build();
        System.out.println("Gaming Laptop");
        gamingLaptop.printConfiguration();

        Laptop simpleLaptop = new SimpleLaptop.SimpleLaptopBuilder()
                .setProcessor("RTX")
                .setRAM("8 GB")
                .setStorage("512 TB")
                .setGraphicCard("2 GB")
                .build();
        System.out.println("Simple Laptop");
        simpleLaptop.printConfiguration();

        System.out.println("-------------------------------------");

//        Prototype
        Computer dell = new Computer("Dell", "XPS 13");
        System.out.println(dell.toString());

        Computer lenovo = (Computer) dell.clone();
        lenovo.setBrand("Lenovo");
        lenovo.setModel("lnv 12");
        System.out.println(lenovo.toString());

        System.out.println("-------------------------------------");


//        Adapter pattern
        OldSystem oldSystem = new OldSystem();
        NewSystemInterface adapter = new OldSystemAdapter(oldSystem);

        NewSystemClient newSystemClient = new NewSystemClient();
        newSystemClient.useNewSystem(adapter);

        System.out.println("-------------------------------------");

//        Bridge Pattern
        Theme darkTheme = new DarkTheme();
        Theme defaultTheme = new DefaultTheme();
        Webpage about = new AboutPage(defaultTheme);
        System.out.println(about.getContent());

        System.out.println("-------------------------------------");

//      Decorator
        Pizza plainPizza = new PlainPizza();
        System.out.println(plainPizza.getDescription());

        Pizza pizzaWithExtraCheese = new ExtraCheese(plainPizza);
        Pizza ChickenPizza = new ChickenPizza(pizzaWithExtraCheese);
        System.out.println(pizzaWithExtraCheese.getCost());
        System.out.println(pizzaWithExtraCheese.getDescription());

        System.out.println(ChickenPizza.getCost());
        System.out.println(ChickenPizza.getDescription());
        System.out.println("-------------------------------------");


//        Composite
        File file1 = new File("picture.png");
        Directory directory1 = new Directory("Mustafiz");
        File file2 = new File("resume.pdf");
        Directory salarySlip = new Directory("salsry_slip");
        File aprilSalry = new File("april_salary.jpeg");
        File maySalry = new File("may_salary.jpeg");

        directory1.addItem(file2);
        directory1.addItem(salarySlip);
        salarySlip.addItem(aprilSalry);
        salarySlip.addItem(maySalry);

        directory1.showDetails();

        System.out.println("-------------------------------------");

//        Facade
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Lights lights = new Lights();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, lights);
        homeTheater.turnOn();
        homeTheater.turnOff();

        System.out.println("-------------------------------------");


//        Chain of Responsibility
        Manager manager = new Manager();
        Director director = new Director();
        VicePresident vicePresident = new VicePresident();

        manager.setNextApprover(director);
        director.setNextApprover(vicePresident);

        PurchaseRequest request = new PurchaseRequest(10000);
        manager.processRequest(request);

        PurchaseRequest request1 = new PurchaseRequest(30000);
        manager.processRequest(request1);

        PurchaseRequest request2 = new PurchaseRequest(50000);
        manager.processRequest(request2);

        System.out.println("-------------------------------------");

//        Command
        TV tv = new TV();
        TvOnCommand tvOnCommand = new TvOnCommand(tv);
        TvOffCommand tvOffCommand = new TvOffCommand(tv);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(tvOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(tvOffCommand);
        remoteControl.pressButton();

        System.out.println("-------------------------------------");

//        Mediator
        AirTrafficControl airTrafficControl = new AirTrafficControlCenter();
        Boeing747 boeing747 = new Boeing747(airTrafficControl);
        AirbusA380 airbusA380 = new AirbusA380(airTrafficControl);

        boeing747.sendMessage("Traffic on the right, descending to 10,000 feet.");
        airbusA380.sendMessage("Acknowledged, maintaining current altitude.");

        System.out.println("-------------------------------------");


//        Momento
        // Creating a text editor
        TextEditor textEditor = new TextEditor();

        // Typing content and saving snapshots
        textEditor.setContent("First draft");
        textEditor.setContent("Second draft");
        textEditor.setContent("Third draft");

        // Performing undo and redo operations
        textEditor.undo();
        System.out.println("After Undo: " + textEditor.getContent());

        textEditor.setContent("Fourth draft");

        textEditor.redo();
        System.out.println("After Redo: " + textEditor.getContent());

        System.out.println("-------------------------------------");

//        Observer
        ANINewsAgency aniNewsAgency = new ANINewsAgency();
        PTINewsAgency ptiNewsAgency = new PTINewsAgency();

        TvNewsOutlet aajtak = new TvNewsOutlet("AAJ TAK");
        TvNewsOutlet republicBharat = new TvNewsOutlet("Republic Bharat");
        TvNewsOutlet ndtv = new TvNewsOutlet("NDTV");

        OnlineNewsOutlet lallantop = new OnlineNewsOutlet("LALLANTOP");
        OnlineNewsOutlet newsloundry = new OnlineNewsOutlet("NEWS LOUNDRY");

        aniNewsAgency.addObserver(aajtak);
        aniNewsAgency.addObserver(ndtv);
        aniNewsAgency.addObserver(lallantop);

        ptiNewsAgency.addObserver(republicBharat);
        ptiNewsAgency.addObserver(newsloundry);

        aniNewsAgency.publishNews("Breaking News: Important Event!");
        System.out.println();
        ptiNewsAgency.publishNews("Weather Update: Sunny day ahead!");

        System.out.println("-------------------------------------");

//      Strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-8765-4321", "John Doe");
        PayPalPayment paypalPayment = new PayPalPayment("xyz@gmail.com");
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setPaymentStrategy(creditCardPayment);
        shoppingCart.checkout(100);

        shoppingCart.setPaymentStrategy(paypalPayment);
        shoppingCart.checkout(50);

        System.out.println("-------------------------------------");


//        State
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
        vendingMachine.dispenseProduct();

        vendingMachine.selectProduct();

        System.out.println("-------------------------------------");

//        Template
        DocumentConverter pdfConvertor = new PdfDocumentConverter();
        DocumentConverter wordConvertor = new WordDocumentConverter();

        pdfConvertor.convertDocument();
        System.out.println();
        wordConvertor.convertDocument();

        System.out.println("-------------------------------------");
    }
}