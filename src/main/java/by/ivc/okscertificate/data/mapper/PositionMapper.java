package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.Position;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PositionMapper extends ReadMapper<Long, Position> {
}
