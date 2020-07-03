/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.CategoryDao;
import dao.ProductsDao;
import dao.TypeProductDao;
import entity.Category;
import entity.Product;
import entity.TypeProduct;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author doanv
 */
@Controller
public class indexController {
    private ProductsDao productdao;
    @Autowired
    public void setProductdao(ProductsDao productdao) {
        this.productdao = productdao;
    }
    
    private CategoryDao categoryDao;
    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    private TypeProductDao typeProductDao;
    @Autowired
    public void setTypeProductDao(TypeProductDao typeProductDao) {
        this.typeProductDao = typeProductDao;
    }
    
    
    @RequestMapping("/index")
    public String viewIndex(Model model,HttpSession session)
    {
       // model.addAttribute("title", "Trang chu");
      //  session.setAttribute("listCategory", categoryDao.getAllCategory());
           List<Product> listBanChay = productdao.getSanPhamBanChay();
           model.addAttribute("listBanChay", listBanChay);
           List<Category> listCategory = categoryDao.getAllCategory();
           model.addAttribute("listCategory", listCategory);
           List<TypeProduct> listTypeProducts=typeProductDao.getListTypeProduct();
           model.addAttribute("listTypeProducts", listTypeProducts);
           
    
        
        // ma danh muc san vi du 4
       // model.addAttribute("listSanPhamTheoDanhMuc", productdao.getSanPhamTheoDanhMuc(4));
       // model.addAttribute("listSanPhamTheoDanhMucLimit4",productdao.getSanPhamTheoDanhMucLimit4(4);
        return "index";
    }
    @RequestMapping("/Store")
    public String viewStore(String tenSanPham, Model model){
        
        List<Product> listProductById = productdao.getByProductName(tenSanPham);
        model.addAttribute("listProductById", listProductById);
       return "store";
    }
    @RequestMapping("/viewProduct")
    public String viewProduct(@RequestParam("idProduct")Integer idProduct,Model model){
        Product p = productdao.getByIdProduct(idProduct);
        model.addAttribute("p", p);
   
        return "product";
    }
  
    
}
