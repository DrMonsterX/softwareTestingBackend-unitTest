package com.sxd.server.mytime.Service.TaskService;

import com.sxd.server.mytime.Dao.NodeMapper;
import com.sxd.server.mytime.Entity.Node;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class NodeService {
    private final NodeMapper nodeMapper;

    public NodeService(NodeMapper nodeMapper) {
        this.nodeMapper = nodeMapper;
    }

    //添加结点
    public int addNode(Node node){
        return nodeMapper.insert(node);
    }

    //删除目标任务的所有结点
    public int deleteAllNode(Integer taskId){
        Example example=new Example(Node.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("taskId",taskId);
        return nodeMapper.deleteByExample(example);
    }

    //修改结点完成信息
    public int finishNode(Integer nodeId,Integer finishNum){
        Node node=nodeMapper.selectByPrimaryKey(nodeId);
        if(node==null){
            return -2;
        }
        node.setIsComplete(finishNum);
        return nodeMapper.updateByPrimaryKey(node);
    }

    //获取任务id对应的所有节点
    public List<Node> getNodeByTaskId(Integer taskId){
        Example example=new Example(Node.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("taskId",taskId);
        return nodeMapper.selectByExample(example);
    }
}
