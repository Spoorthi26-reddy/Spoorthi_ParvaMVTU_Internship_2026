package com.example.productmanager.controller;
import com.example.productmanager.entity.Product;
import com.example.productmanager.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/products")
public class ProductController {
private final ProductService service;
public ProductController(ProductService service) {
this.service = service;
}
// LIST all products
@GetMapping
public String list(@RequestParam(required = false) String keyword,
Model model) {
if (keyword != null && !keyword.isBlank()) {
model.addAttribute("products", service.search(keyword));
model.addAttribute("keyword", keyword);
} else {
model.addAttribute("products", service.findAll());
}
return "products/list";
}
// SHOW create form
@GetMapping("/new")
public String showCreateForm(Model model) {
model.addAttribute("product", new Product());
return "products/form";
}
// HANDLE create form submission
@PostMapping
public String create(@Valid @ModelAttribute Product product,
BindingResult result,
@RequestParam("imageFile") MultipartFile imageFile,
RedirectAttributes ra) throws Exception {
if (result.hasErrors()) return "products/form";
service.save(product, imageFile);
ra.addFlashAttribute("successMsg", "Product created!");
return "redirect:/products";

}
// SHOW edit form
@GetMapping("/{id}/edit")
public String showEditForm(@PathVariable Long id, Model model) {
model.addAttribute("product", service.findById(id));
return "products/form";
}
// HANDLE edit form submission
@PostMapping("/{id}")
public String update(@PathVariable Long id,
@Valid @ModelAttribute Product product,
BindingResult result,
@RequestParam("imageFile") MultipartFile imageFile,
RedirectAttributes ra) throws Exception {
if (result.hasErrors()) return "products/form";
service.update(id, product, imageFile);
ra.addFlashAttribute("successMsg", "Product updated!");
return "redirect:/products";
}
// SHOW product detail
@GetMapping("/{id}")
public String detail(@PathVariable Long id, Model model) {
model.addAttribute("product", service.findById(id));
return "products/detail";
}
// DELETE product
@PostMapping("/{id}/delete")
public String delete(@PathVariable Long id,
RedirectAttributes ra) throws Exception {
service.delete(id);
ra.addFlashAttribute("successMsg", "Product deleted!");
return "redirect:/products";
}
}