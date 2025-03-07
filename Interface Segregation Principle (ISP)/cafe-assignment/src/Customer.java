import java.util.Scanner;


interface IRatingService {
    void collectRating();
}

interface IPaymentService {
    void processPayment();
}


class DefaultRatingService implements IRatingService {
    public void collectRating() {
        System.out.println("Collecting rating from the customer...");
    }
}

class DefaultPaymentService implements IPaymentService {
    public void processPayment() {
        System.out.println("Processing payment...");
    }
}


public class Customer implements staff {
    private final IRatingService ratingService;
    private final IPaymentService paymentService;

   
    public Customer(IRatingService ratingService, IPaymentService paymentService) {
        this.ratingService = ratingService;
        this.paymentService = paymentService;
    }

    public void rateService() {
        ratingService.collectRating();
    }

    public void payOrder() {
        paymentService.processPayment();
    }
}
