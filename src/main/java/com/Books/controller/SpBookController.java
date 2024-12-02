   package com.Books.controller;

   import com.Books.entity.pojo.SpBook;
   import com.Books.service.ISpBookService;
   import io.swagger.annotations.Api;
   import io.swagger.annotations.ApiOperation;
   import lombok.RequiredArgsConstructor;
   import org.springframework.web.bind.annotation.*;

   import javax.websocket.server.PathParam;

   /**
    * <p>
    * 书籍表 前端控制器
    * </p>
    *
    * @author hllqk
    * @since 2024-11-30
    */
   @Api(tags = "书籍管理")
   @RestController
   @RequestMapping("/sp-book")
   @RequiredArgsConstructor
   public class SpBookController {
       @RequestMapping("")
    public String hllqk() {
        return "hello world";
    }
       private final ISpBookService spBookService;

       @PostMapping("/add")
       @ApiOperation("添加书籍")
       public void save(@RequestBody SpBook spBook) {
           spBook.setName(spBook.getName());
           spBook.setType(spBook.getType());
           spBook.setDescription(spBook.getDescription());
           spBookService.save(spBook); // 保存书籍
       }
       @DeleteMapping("{id}")
       @ApiOperation("删除书籍")

   public void delete(@PathParam ("用户id")@PathVariable("id") Integer id) {
           spBookService.removeById(id); // 删除书籍
       }
       @GetMapping("/get/{id}")
       @ApiOperation("获取书籍")
       public SpBook get(@PathVariable("id") Integer id) {
           return spBookService.getById(id); // 获取书籍
       }
       @PutMapping("/update/{id}/type/{type}")
       @ApiOperation("更新书籍")
       public void update(@PathVariable("id") Integer id, @PathVariable("type") String type) {
           spBookService.updateType(id, type);
       }
   }
   