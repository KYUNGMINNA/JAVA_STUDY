
//0328--

@Controller

@GetMapping("/");

@PostMapping("/");

ModelAndView mv=new ModelAndView();
mv.setViewName("jsp file name");

mv.addObejct("name" , Obejct);

return mv;

@GetMapping("/mapping")
public String test(@ReuqestParam("ttttt") int detail){ 
}
//--0328
