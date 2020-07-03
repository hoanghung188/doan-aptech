/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.List;

/**
 *
 * @author hoanghung
 */
public interface ProductsDao {
   public List<Product> getSanPhamBanChay();
    public List<Product> getTop5SanPhamMoi();
   public List<Product> getSanPhamTheoDanhMuc(int IdCategory);
   public List<Product> getSanPhamTheoDanhMucLimit4(int IdCategory);
   public List<Product> getByProductName(String nameProduct);
   public Product getByIdProduct(Integer idProduct);
    
    
}
