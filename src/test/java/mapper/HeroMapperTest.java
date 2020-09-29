package mapper;

import com.rusnak.dim.Application;
import com.rusnak.dim.dto.HeroDto;
import com.rusnak.dim.entity.HeroEntity;
import com.rusnak.dim.mapper.GenericMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class HeroMapperTest {

  @Autowired
  private GenericMapper<HeroEntity, HeroDto> mapper;

  @Test
  public void testMapEntityToDto() {
    HeroEntity entity = new HeroEntity();
    entity.setId(1L);
    entity.setName("name");
    entity.setDescription("description");
    entity.setRank(1);

    HeroDto dto = mapper.mapEntityToDto(entity);

    Assertions.assertEquals(entity.getName(), dto.getName());
    Assertions.assertEquals(entity.getDescription(), dto.getDescription());
    Assertions.assertEquals(entity.getRank(), dto.getRank());
  }

  @Test
  public void testMapDtoToEntity() {
    HeroDto dto = new HeroDto();
    dto.setName("name");
    dto.setDescription("description");
    dto.setRank(1);

    HeroEntity entity = mapper.mapDtoToEntity(dto);

    Assertions.assertNull(entity.getId());
    Assertions.assertEquals(dto.getName(), entity.getName());
    Assertions.assertEquals(dto.getDescription(), entity.getDescription());
    Assertions.assertEquals(dto.getRank(), entity.getRank());
  }
}
