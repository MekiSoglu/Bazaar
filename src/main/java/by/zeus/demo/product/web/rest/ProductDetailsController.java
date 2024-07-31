package by.zeus.demo.product.web.rest;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.base.web.rest.BaseResource;
import by.zeus.demo.product.domain.ProductDetails;
import by.zeus.demo.product.facade.ProductDetailsFacade;
import by.zeus.demo.product.facade.ProductFacade;
import by.zeus.demo.product.service.ProductDetailsService;
import by.zeus.demo.product.web.dto.ProductDetailsDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prdDetails")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )

public class ProductDetailsController extends BaseResource<ProductDetailsDTO,ProductDetails> {


    public ProductDetailsController(final ProductDetailsFacade facade) {
        super(facade);
    }

    @Override
    public Class<?> getLoggerClass() {
        return this.getClass();
    }
    @Override
    public ProductDetailsFacade getFacade() {
        return (ProductDetailsFacade) super.getFacade();
    }
}
