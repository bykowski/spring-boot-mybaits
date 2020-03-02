package pl.bykowski.springbootmybaits.api;


import org.springframework.web.bind.annotation.*;
import pl.bykowski.springbootmybaits.mapper.CityMapper;
import pl.bykowski.springbootmybaits.model.City;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityApi {

    private CityMapper cityMapper;

    public CityApi(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @GetMapping
    public List<City> getAll() {
        return cityMapper.findAll();
    }


    @GetMapping("/id/{id}")
    public City getOne(@PathVariable Long id) {
        return cityMapper.findById(id);
    }

    @PostMapping
    public void addCity(@RequestBody City city) {
       cityMapper.insert(city);
    }
}
