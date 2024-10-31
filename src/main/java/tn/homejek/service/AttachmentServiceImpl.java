package tn.homejek.service;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.homejek.config.RandomString;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final Path root = Paths.get("/var/www/html/uploads");

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            this.init();
            String timeStamp = RandomString.getAlphaNumericString(30);
            Optional<String> extOp = this.getExtension(file.getOriginalFilename());
            String ext = "";
            if (extOp.isPresent())
                ext = extOp.get();
            else
                ext = "jpg";
            Files.copy(file.getInputStream(), this.root.resolve(timeStamp + '.' + ext));
            this.changesPermissions();
            return timeStamp+'.'+ext;
        } catch (Exception ex) {
            return null;
        }
    }

    public Optional<String> getExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    @Override
    public void init() {
        try {
            File directory = new File(String.valueOf(root));
            if (! directory.exists()){
                directory.mkdir();
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }
//
//    @Override
//    public BlogAttachment saveBlogAttachment(MultipartFile file, Long id) {
//        BlogAttachment res = null;
//        try {
//            this.init();
//            String timeStamp = "B_"+id+"_"+RandomString.getAlphaNumericString(30);
//            Optional<String> extOp = this.getExtension(file.getOriginalFilename());
//            String ext = "";
//            if (extOp.isPresent())
//                ext = extOp.get();
//            else
//                ext = "jpg";
//            Files.copy(file.getInputStream(), this.root.resolve(timeStamp + '.' + ext));
//            res = new BlogAttachment();
//            res.setBlog(new Blog(id));
//            res.setName(timeStamp + '.' + ext);
//            res.setUrl("uploads/"+res.getName());
//            this.changesPermissions();
//            return res;
//        } catch (Exception e) {
//            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public ProductAttachment saveProductAttachment(MultipartFile file, Long id) {
//        ProductAttachment res = null;
//        try {
//            this.init();
////            String timeStamp = Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
//            String timeStamp = "P_"+id+"_"+RandomString.getAlphaNumericString(30);
//            Optional<String> extOp = this.getExtension(file.getOriginalFilename());
//            String ext = "";
//            if (extOp.isPresent())
//                ext = extOp.get();
//            else
//                ext = "jpg";
//            Files.copy(file.getInputStream(), this.root.resolve(timeStamp + '.' + ext));
//            res = new ProductAttachment();
//            res.setProduct(new Product(id));
//            res.setName(timeStamp + '.' + ext);
//            res.setUrl("uploads/"+res.getName());
//            res.setPrimary(false);
//            this.changesPermissions();
//            return res;
//        } catch (Exception e) {
//            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
//        }
//    }
//
//
//    @Override
//    public ProductCategoryAttachment saveProductCategoryAttachment(MultipartFile file, Long id) {
//        ProductCategoryAttachment res = null;
//        try {
//            this.init();
//            String timeStamp = "PC_"+id+"_"+RandomString.getAlphaNumericString(30);
//            Optional<String> extOp = this.getExtension(file.getOriginalFilename());
//            String ext = "";
//            if (extOp.isPresent())
//                ext = extOp.get();
//            else
//                ext = "jpg";
//            Files.copy(file.getInputStream(), this.root.resolve(timeStamp + '.' + ext));
//            res = new ProductCategoryAttachment();
//            res.setProductCategory(new ProductCategory(id));
//            res.setName(timeStamp + '.' + ext);
//            res.setUrl("uploads/"+res.getName());
//            this.changesPermissions();
//            return res;
//        } catch (Exception e) {
//            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
//        }
//    }
//
//    public Optional<String> getExtension(String filename) {
//        return Optional.ofNullable(filename)
//                .filter(f -> f.contains("."))
//                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
//    }
//
//    @Override
//    public void uploadMultiFiles(List<MultipartFile> files) {
//        try {
//            this.init();
//            for (MultipartFile file : files){
//                Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
//        }
//    }
//
//    public void changesPermissions(){
//        try{
//            Process p = Runtime.getRuntime().exec(new String[]{"sh","-c","sudo chmod -R 775 /var/www/html/uploads"});
//        }catch (Exception ex){
//            System.out.println("Cannot Execute COMMAND");
//        }
//    }
//
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    public void changesPermissions(){
        try{
            Process p = Runtime.getRuntime().exec(new String[]{"sh","-c","sudo chmod -R 775 /var/www/html/uploads"});
        }catch (Exception ex){
            System.out.println("Cannot Execute COMMAND");
        }
    }

    @Override
    public void deleteFile(String name) {
        Path fileRoot = Paths.get("/var/www/html/uploads/"+name);
        FileSystemUtils.deleteRecursively(fileRoot.toFile());
    }
//
//    @Override
//    public Stream<Path> loadAll() {
//        try {
//            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not load the files!");
//        }
//    }
}
