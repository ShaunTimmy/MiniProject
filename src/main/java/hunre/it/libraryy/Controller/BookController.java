package hunre.it.libraryy.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import hunre.it.libraryy.Entity.Book;
import hunre.it.libraryy.Entity.Taikhoan;
import hunre.it.libraryy.Responitory.BookReponsitory;
import hunre.it.libraryy.Responitory.TaikhoanReponsitory;
import hunre.it.libraryy.Services.BookService;

@Controller
public class BookController {
	@Autowired
	public BookService service;
	@Autowired
	public BookReponsitory repo;
	@Autowired
    private BCryptPasswordEncoder encoder;
	@Autowired
	private TaikhoanReponsitory taikhoanReponsitory;
	

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("taikhoan", new Taikhoan());
        return "register"; 
    }
    @PostMapping("/register")
	 public String register(@ModelAttribute Taikhoan tk) {
	     tk.setPassword(encoder.encode(tk.getPassword()));
	     taikhoanReponsitory.save(tk);
	     return "redirect:/login";
	 }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
	

	@GetMapping("/thuvien")
	public String showTT(Model model) {
		model.addAttribute("sach", service.DanhsachTL());
		return "home";
	}
	// them moi
			@GetMapping("/thuvien/add")
			public String showForm(Model model) {
				model.addAttribute("sach", new Book());
				return "addTL";
			}
			@PostMapping("/thuvien/add")
			public String saveStudent(@ModelAttribute("sach") Book sach, BindingResult result, Model model) {
				if(repo.existsByMasach(sach.getMasach())) {
					 result.rejectValue("masach", "error.book", "Mã sách đã tồn tại.");
				}
				 if (result.hasErrors()) {
				        return "addTL";
				    }
			   service.LuuTT(sach);
			    return "redirect:/thuvien";
			}
			//cap nhat 
			@GetMapping("/thuvien/edit/{id}")
			public String showEditForm(@PathVariable("id") Long id, Model model) {
			   Book tl = service.LayTTByID(id);
			    if (tl != null) {
			        model.addAttribute("sach", tl);
			        return "editTL"; 
			    } else {
			        return "redirect:/thuvien";
			    }
			}
			@PostMapping("/thuvien/update")
			public String updateStudent(@ModelAttribute("sach") Book sach) {
			    service.capNhat(sach);// save() tự động cập nhật nếu id tồn tại
			    return "redirect:/thuvien";
			}
			@GetMapping("/thuvien/delete/{id}")
			public String deleteStudent(@PathVariable("id") Long id) {
			    service.XoaTT(id);
			    return "redirect:/thuvien"; // Quay lại danh sách sau khi xóa
			}
			//tim kiem
			@GetMapping("/thuvien/search")
			public String search(@RequestParam("keyword") String keyword, Model model) {
			    List<Book> result = service.searchByID(keyword);
			    model.addAttribute("sach", result);
			    return "home";
			}


}
