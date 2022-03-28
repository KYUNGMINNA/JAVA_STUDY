
//0328--

@Controller

@GetMapping("/");

@PostMapping("/");

ModelAndView mv=new ModelAndView();
mv.setViewName("jsp file name");

mv.addObejct("name" , Obejct);

return mv;


//--0328
