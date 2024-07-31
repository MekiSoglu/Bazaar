package by.zeus.demo.product.facade;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.product.domain.Product;
import by.zeus.demo.product.service.ProductService;
import by.zeus.demo.product.web.dto.ProductDTO;
import by.zeus.demo.product.web.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class ProductFacade extends BaseFacade<ProductDTO, Product> {

    public ProductFacade(final ProductService service, final ProductMapper mapper) {
        super(service, mapper);
    }
    @Override
    public Page<ProductDTO> findAll(final Pageable pageable) {
        Page<Product> productPage = getService().findAll(pageable);
        return productPage.map(getMapper()::toDto);
    }

    public Page<ProductDTO> findByCategoryId(Long categoryId , Pageable pageable) {
        Page<Product> productPage = getService().findByCategoryId(categoryId,pageable);
        return productPage.map(getMapper()::toDto);
    }

    public Page<ProductDTO> findByName(String name , Pageable pageable) {
        Page<Product> productPage = getService().findByName(name,pageable);
        return productPage.map(getMapper()::toDto);
    }

    public Map<String,String> showDetails(Long Id){
        return getService().showDetails(Id);
    }


    @Override
    public ProductService getService() {
        return (ProductService) super.getService();
    }

    @Override
    public ProductMapper getMapper() {
        return (ProductMapper) super.getMapper();
    }

    @Override
    public Class<ProductDTO> getDtoClass() {
        return ProductDTO.class;
    }
}
