package com.example.demo.web;

import com.example.demo.models.ChargeResult;
import com.example.demo.repository.JpaChargeResultRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChargeController {

    private final StripeService paymentsService;
    private final JpaChargeResultRepository chargeResultRepository;

    public ChargeController(StripeService paymentsService, JpaChargeResultRepository chargeResultRepository) {
        this.paymentsService = paymentsService;
        this.chargeResultRepository = chargeResultRepository;
    }

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
            throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());

        ChargeResult chargeResult = new ChargeResult(charge.getId(),charge.getStatus(),
                charge.getId(),charge.getBalanceTransaction());
        chargeResultRepository.save(chargeResult);

        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
