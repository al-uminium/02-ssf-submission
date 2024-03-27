package sg.edu.nus.iss.ibfb4ssfassessment.repository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonObject;
import sg.edu.nus.iss.ibfb4ssfassessment.config.RedisConfig;

@Repository
public class RedisRepo {
  @Autowired @Qualifier(RedisConfig.REDIS_BEAN)
  private RedisTemplate<String, String> template;

  public void mapAdd(JsonObject json) {
    template.opsForHash().put("movies", json.get("Id").toString(), json.toString());
  }

  public String mapGet(Integer key) {
    return template.opsForHash().get("movies", String.valueOf(key)).toString();
  }

  public Long mapSize() {
    return template.opsForHash().size("movies");
  }

  public List<Object> getAllMapValues() {
    return template.opsForHash().values("movies");
  }

  public Set<Object> getAllMapKeys() {
    return template.opsForHash().keys("movies");
  }
}
